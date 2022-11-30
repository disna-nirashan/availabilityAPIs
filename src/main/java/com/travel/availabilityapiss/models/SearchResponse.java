package com.travel.availabilityapiss.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "Response format")

public class SearchResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "Meta data of the response")
    private ResponeMetaData metaData;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "Data of the response")
    private List<SearchQueryResult> data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "Error data of the response")
    private ErrorData errorData;

    public static SearchResponse create() {
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
