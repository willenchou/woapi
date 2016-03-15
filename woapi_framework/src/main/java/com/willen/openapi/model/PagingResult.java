package com.willen.openapi.model;

import java.util.List;

import com.willen.openapi.jdbc.page.Paging;

public class PagingResult<T> {

    private List<T> rows;

    private long total;

    // ----------------------------------------------------------------------------------------------------

    public PagingResult(Paging<T> paging) {
        rows = paging.getItemList();
        total = paging.getTotalCount();
    }

    // ----------------------------------------------------------------------------------------------------

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
