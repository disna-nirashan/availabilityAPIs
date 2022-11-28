package com.travel.availabilityapiss.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class SearchResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ResponeMetaData metaData;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<SearchQueryResult> data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ErrorData errorData;

    public ResponeMetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(ResponeMetaData metaData) {
        this.metaData = metaData;
    }

    public List<SearchQueryResult> getData() {
        return data;
    }

    public void setData(List<SearchQueryResult> data) {
        this.data = data;
    }

    public ErrorData getErrorData() {
        return errorData;
    }

    public void setErrorData(ErrorData errorData) {
        this.errorData = errorData;
    }
}
