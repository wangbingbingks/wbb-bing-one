package com.corsface.base.web;

import com.corsface.base.proto.EasyuiTreeNode;
import com.corsface.base.service.BeModuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Created by wbb on 2020/8/13.
 */
public class FunctionController extends AbstractApiController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BeModuleService beModuleService;

    @RequestMapping(value = "/admin/function/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("index");

        DefaultMutableTreeNode root = beModuleService.getTreeByParentId(0, true);

        EasyuiTreeNode euRoot = beModuleService.copyTree(root);
        String json = beModuleService.toEuTreeJson(euRoot);

        modelAndView.addObject("json", json);
        System.out.println("json = " + json);
        return modelAndView;
    }

    @RequestMapping(value = "/Text", method = RequestMethod.POST)
    public String fileAdd(MultipartHttpServletRequest request) {
        MultipartFile file = request.getFile("img");
        String name = file.getName();
        System.out.println("name = " + name);

        String origName = file.getOriginalFilename();
        System.out.println("origName = " + origName);
        return "success";
    }
}
