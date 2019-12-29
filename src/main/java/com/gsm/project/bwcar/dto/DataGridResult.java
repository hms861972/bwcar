package com.gsm.project.bwcar.dto;

import java.util.List;

public class DataGridResult {

    //总记录数
    private long total;
    //每次查询的数据集合
    private List<?> rows;

    public DataGridResult() {
    }

    public DataGridResult(long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
