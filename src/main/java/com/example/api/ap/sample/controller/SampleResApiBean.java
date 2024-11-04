package com.example.api.ap.sample.controller;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SampleResApiBean {

    @NotNull
    private Integer sampleInteger;

    @NotNull
    private String sampleString;

}
