package com.example.api.ap.sample.controller;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.api.ap.sample.domain.model.SampleModel;

@Mapper(componentModel = "spring")
public interface SampleBeanMapper {

    @Mapping(target = "sampleInteger", source = "sampleNumber")
    public SampleResApiBean toBean(SampleModel sampleModel);

    public List<SampleResApiBean> toBeanList(List<SampleModel> sampleModels);
}
