package com.product.sc.controller;

import com.corsface.base.proto.ReturnData;
import com.corsface.base.web.AbstractApiController;
import com.product.sc.util.ExcelUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExcelImportController extends AbstractApiController {

    @RequestMapping(value = "/importStudent",method = RequestMethod.POST)
    public ReturnData importEntity(MultipartHttpServletRequest request){
        prepare(request);
        ReturnData returnData = getReturnDataFromReqAttr(request);

        if (!checkUploadFaceParm(request)) {
            return returnData;
        }

        MultipartFile multipartFile=request.getFile("excel_file");
        try{
            List<List<String>> lists= ExcelUtils.getBankListByExcel(multipartFile.getInputStream(),multipartFile.getOriginalFilename());
            List<String> list= getImportStudentEntity(lists);
            returnData.setResultForSucces(list);
        }catch (Exception e){
            e.printStackTrace();
            returnData.setResultForCommonFail(e.getMessage(),null);
        }
        return returnData;
    }

    private boolean checkUploadFaceParm(MultipartHttpServletRequest request) {
        ReturnData returnData = getReturnDataFromReqAttr(request);

        MultipartFile file1 = request.getFile("excel_file");

        if (file1 == null || file1.isEmpty()) {
            returnData.setResultForInvalidPara("请上传文件(excel_file)", "invalid excel_file");
            return false;
        }

        return true;
    }

    private List<String> getImportStudentEntity(List<List<String>> lists){
        List<String> rst = new ArrayList<>();
        if(lists == null || lists.size()==0){
            return rst;
        }

        for (int i = 0; i < lists.size(); i++) {
            List<String> list = lists.get(i);
            for (int k = 0; k < list.size(); k++) {
                System.out.println("list.get = " + list.get(k));
                rst.add(list.get(k));
            }
            System.out.println("---------------------------------");
        }

        return rst;
    }
}
