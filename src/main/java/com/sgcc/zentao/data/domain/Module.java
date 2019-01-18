package com.sgcc.zentao.data.domain;

import org.apache.ibatis.type.Alias;

/**
 * <b>概述</b>：
 * <blockquote>module表数据字段映射</blockquote>
 * <p/>
 * <b>功能</b>：
 * <blockquote>请补充</blockquote>
 * @author  <a href="mailto:1284676837@qq.com">唐亮</a>
 **/
@Alias("MODULE")
public class Module {
    private int id;
    private int root;
    private int branch;
    private String name;
    private int parent;
    private String path;
    private int grade;
    private int order;
    private String type;
    private String owner;
    private String short_t;
    private String deleted;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getRoot() {
        return root;
    }
    public void setRoot(int root) {
        this.root = root;
    }
    public int getBranch() {
        return branch;
    }
    public void setBranch(int branch) {
        this.branch = branch;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getParent() {
        return parent;
    }
    public void setParent(int parent) {
        this.parent = parent;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getShort_t() {
        return short_t;
    }
    public void setShort_t(String short_t) {
        this.short_t = short_t;
    }
    public String getDeleted() {
        return deleted;
    }
    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}
