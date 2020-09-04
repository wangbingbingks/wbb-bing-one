package com.corsface.base.proto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Created by wbb on 2020/8/13.
 */
public class EasyuiTreeNode implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String text;
    private String iconCls;
    private String state;
    private boolean checked;
    private HashMap attributes;
    private List<EasyuiTreeNode> children;

    @JsonIgnore
    private EasyuiTreeNode parent;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public HashMap getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap attributes) {
        this.attributes = attributes;
    }

    public List<EasyuiTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<EasyuiTreeNode> children) {
        this.children = children;
    }

    public EasyuiTreeNode getParent() {
        return parent;
    }

    public void setParent(EasyuiTreeNode parent) {
        this.parent = parent;
    }

    public void remove(EasyuiTreeNode child) {
        if (child != null) {
            if (children != null) {
                children.remove(child);
            }
            child.setParent(null);
        }
    }

    public void addChild(EasyuiTreeNode child) {
        if (children == null) {
            children = new ArrayList<EasyuiTreeNode>();
        }

        if (child != null) {
            if (child.getParent() == this) {
                //不做处理
            } else {
                EasyuiTreeNode oldParent = child.getParent();
                if (oldParent != null) {
                    oldParent.remove(child);
                }
                child.setParent(this);
                this.children.add(child);
            }
        } else {
            // child 为空
        }

    }

    @SuppressWarnings("unchecked")
    public void addAttribute(Object key, Object value) {
        if (attributes == null) {
            attributes = new HashMap();
        }
        attributes.put(key, value);
    }
}
