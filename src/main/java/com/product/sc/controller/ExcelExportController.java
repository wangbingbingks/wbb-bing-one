package com.product.sc.controller;

import com.corsface.base.proto.ReturnData;
import com.corsface.base.web.AbstractApiController;
import com.corsface.util.DateUtils;
import com.product.sc.dao.CfMGateConfigDao;
import com.product.sc.entity.CfMGateStrategyConfig;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;

@RestController
public class ExcelExportController extends AbstractApiController {

    @Autowired
    private CfMGateConfigDao cfMGateConfigDao;


    @RequestMapping(value = "/exportKey", method = RequestMethod.POST)
    public void exportKey(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<CfMGateStrategyConfig> ketCodeDates = cfMGateConfigDao.getAllCfMGateStrategyConfig();

        String[] tableHeaders = {"id", "所属分组id", "设备sn", "策略类型", "开始时间", "截止时间", "周几", "开始日期", "截止日期", "创建时间", "修改时间"};

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sheet1");
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setColor(HSSFColor.RED.index);
        int rowIndex = 1;
        cellStyle.setFont(font);

        HSSFRow row = sheet.createRow(0);
        // 创建表头
        for (int i = 0; i < tableHeaders.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(tableHeaders[i]);
            cell.setCellStyle(cellStyle);
        }

        for (int i = 0; i < ketCodeDates.size(); i++) {
            CfMGateStrategyConfig config = ketCodeDates.get(i);
            row = sheet.createRow(rowIndex++);

            row.createCell(0).setCellValue(config.getId());
            row.createCell(1).setCellValue(config.getGateStrategyId());
            row.createCell(2).setCellValue(config.getAppclientSn());
            row.createCell(3).setCellValue(config.getTimeType());
            row.createCell(4).setCellValue(config.getStartTime());
            row.createCell(5).setCellValue(config.getEndTime());
            row.createCell(6).setCellValue(config.getSetOpenDate());
            if(config.getOpenStartDate() != null){
                row.createCell(7).setCellValue(DateUtils.date2string(config.getOpenStartDate(), DateUtils.YYYY_MM_DD_HH_MM_SS));
            }else{
                row.createCell(7).setCellValue("");
            }
            if(config.getOpenEndDate() != null){
                row.createCell(8).setCellValue(DateUtils.date2string(config.getOpenEndDate(), DateUtils.YYYY_MM_DD_HH_MM_SS));
            }else{
                row.createCell(8).setCellValue("");
            }
            row.createCell(9).setCellValue(DateUtils.date2string(config.getCreateDate(), DateUtils.YYYY_MM_DD_HH_MM_SS));
            row.createCell(10).setCellValue(DateUtils.date2string(config.getModifyDate(), DateUtils.YYYY_MM_DD_HH_MM_SS));

        }
        OutputStream outputStream = response.getOutputStream();
        response.reset();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=template.xls");

        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

}
