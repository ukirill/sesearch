package com.sesearch.models;

public class StackExchangeRequest {
    public String searchString;
    public int pageSize;
    public int pageNum;
    public String sortField;

    public StackExchangeRequest(String searchString) {
        this.searchString = searchString;
    }

    public StackExchangeRequest(String searchString, int pageNum, int pageSize, String sortField) {
        this.searchString = searchString;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        if (sortField != null && !sortField.isEmpty()) {
            this.sortField = sortField;
        }
        else {
            this.sortField = "activity";
        }
    }
}
