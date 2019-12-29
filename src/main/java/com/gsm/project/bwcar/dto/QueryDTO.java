package com.gsm.project.bwcar.dto;

public class QueryDTO {

    //起始行
    private int offset;
    //每行记录数
    private int limit;
    //排序 正序/倒序
    private String order;
    //排序的字段
    private String sort;
    //搜索的内容
    private String search;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }


}
