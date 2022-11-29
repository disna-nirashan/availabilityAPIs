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

    public static SearchResponse create(){
       return new SearchResponse();
    }

    public ResponeMetaData getMetaData() {
        return metaData;
    }

    public SearchResponse setMetaData(ResponeMetaData metaData) {
        this.metaData = metaData;
        return this;
    }

    public List<SearchQueryResult> getData() {
        return data;
    }

    public SearchResponse setData(List<SearchQueryResult> data) {
        this.data = data;
        return this;
    }

    public ErrorData getErrorData() {
        return errorData;
    }

    public SearchResponse setErrorData(ErrorData errorData) {
        this.errorData = errorData;
        return this;
    }
}
