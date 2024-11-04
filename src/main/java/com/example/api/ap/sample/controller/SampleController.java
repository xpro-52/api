package com.example.api.ap.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.ap.sample.domain.service.SampleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SampleController {

    @Autowired
    private SampleBeanMapper sampleBeanMapper;

    @Autowired
    private SampleService sampleService;

    @RequestMapping(path = "/sample/{id}", method = RequestMethod.GET)
    public SampleResApiBean getSample(@PathVariable("id") String id) {
        SampleResApiBean sampleResponseApiBean = sampleBeanMapper.toBean(sampleService.getSample(id));
        return sampleResponseApiBean;
    }

    @RequestMapping(path = "/sample/list", method = RequestMethod.GET)
    public List<SampleResApiBean> getSampleList() {
        log.debug(SecurityContextHolder.getContext().getAuthentication().getName());
        List<SampleResApiBean> sampleListResApiBean = sampleBeanMapper.toBeanList(sampleService.getSamples());
        return sampleListResApiBean;
    }
}
