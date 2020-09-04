package com.corsface.base.service;

import com.corsface.base.dao.BeModuleDao;
import com.corsface.base.entity.BeFunction;
import com.corsface.base.entity.BeModule;
import com.corsface.base.proto.EasyuiTreeNode;
import com.corsface.base.util.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by wbb on 2020/8/13.
 */
@Service
public class BeModuleService {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BeModuleDao beModuleDao;

    private static EasyuiTreeNode copyNode(DefaultMutableTreeNode node) {
        if (node == null) {
            return null;
        }

        EasyuiTreeNode rst = new EasyuiTreeNode();
        BeModule tblBemodule = (BeModule) node.getUserObject();

        rst.setId(tblBemodule.getId());
        rst.setState("open");
        rst.setText(tblBemodule.getName());
        rst.setIconCls(tblBemodule.getIcon());
        rst.setChecked(false);

        if (!Utils.isBlank(tblBemodule.getUrl())) {
            rst.addAttribute("url", tblBemodule.getUrl());
        }

        if (tblBemodule.getDefaultFId() != -1) {
            rst.addAttribute("dfid", tblBemodule.getDefaultFId());
        }

        return rst;
    }

    public DefaultMutableTreeNode getTreeByParentId(long parentId, boolean showHide) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode();

        if (parentId == 0) {
            BeModule beRoot = new BeModule();
            beRoot.setId(Long.valueOf(0));
            beRoot.setIsLeaf(0);
            beRoot.setName("ROOT");

            root.setUserObject(beRoot);
        } else {
            BeModule beRoot = beModuleDao.getBeModuleById(parentId);
            root.setUserObject(beRoot);
        }

        //广度遍历，生成树形结构

        LinkedList<DefaultMutableTreeNode> queue = new LinkedList<DefaultMutableTreeNode>();
        queue.offer(root);

        DefaultMutableTreeNode node = null;
        BeModule module = null;

        while (queue.size() > 0) {
            node = queue.poll();
            module = (BeModule) node.getUserObject();

            if (module.getIsLeaf() == 1) {
                //叶子节点
                BeFunction befunction = beModuleDao.getDefaultFunction(module.getId());

                if (befunction != null) {
                    module.setUrl(befunction.getUrl());
                    module.setDefaultFId(befunction.getId());
                }

            } else {
                List<BeModule> beModules = beModuleDao.getVisibleBeModulesByParentId(module.getId(), showHide);
                if (beModules != null) {
                    for (int i = 0; i < beModules.size(); i++) {
                        DefaultMutableTreeNode node_child = new DefaultMutableTreeNode();
                        node_child.setUserObject(beModules.get(i));
                        node.add(node_child);

                        queue.offer(node_child);
                        logger.debug("-->module.name:" + ((BeModule) beModules.get(i)).getName());

                    }
                }
            }
        }

        return root;
    }

    public EasyuiTreeNode copyTree(DefaultMutableTreeNode root) {
        //        EasyuiTreeNode rst = new EasyuiTreeNode();
        EasyuiTreeNode rst;

        LinkedList<DefaultMutableTreeNode> queue = new LinkedList<DefaultMutableTreeNode>();
        LinkedList<EasyuiTreeNode> euQueue = new LinkedList<EasyuiTreeNode>();


        DefaultMutableTreeNode node = null;
        DefaultMutableTreeNode childNode = null;

        EasyuiTreeNode euNode = null;
        EasyuiTreeNode euChildNode = null;

        rst = copyNode(root);
        queue.offer(root);
        euQueue.offer(rst);

        while (queue.size() > 0) {
            node = queue.poll();
            euNode = euQueue.poll();

            Enumeration enu = node.children();
            while (enu.hasMoreElements()) {
                childNode = (DefaultMutableTreeNode) enu.nextElement();
                queue.offer(childNode);

                euChildNode = copyNode(childNode);
                euNode.addChild(euChildNode);
                euQueue.offer(euChildNode);
            }
        }

        return rst;
    }

    public String toEuTreeJson(EasyuiTreeNode node) {
        String json = null;

        ObjectMapper mapper = new ObjectMapper();
        try {
            ArrayList<EasyuiTreeNode> list = new ArrayList<EasyuiTreeNode>();
            list.add(node);

//            json = mapper.writeValueAsString(node.getChildren());
            json = mapper.writeValueAsString(list);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            json = null;
        }

        return json;
    }
}
