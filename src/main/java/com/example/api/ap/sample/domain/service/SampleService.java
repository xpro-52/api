package com.example.api.ap.sample.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.example.api.ap.sample.domain.model.SampleModel;
import com.example.api.ap.sample.domain.repository.SampleRepository;
import com.example.api.db.entity.Sample;
import com.example.api.fw.exception.ResourceNotFoundException;

@Service
public class SampleService {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private SampleRepository sampleRepository;

    public SampleModel getSample(String id) {
        SampleModel sampleModel = new SampleModel();
        Sample sample = sampleRepository.selectById(id)
                .orElseThrow(() -> {
                    String message = messageSource.getMessage("sample.not.found", new Object[] { id }, null);
                    return new ResourceNotFoundException(message);
                });
        sampleModel.setSampleNumber(sample.getNumber());
        sampleModel.setSampleString(sample.getString());
        return sampleModel;
    }

    public List<SampleModel> getSamples() {
        List<Sample> samples = sampleRepository.selectAll();
        return samples.stream()
                .map(sample -> {
                    SampleModel sampleModel = new SampleModel();
                    sampleModel.setSampleNumber(sample.getNumber());
                    sampleModel.setSampleString(sample.getString());
                    return sampleModel;
                })
                .toList();
    }
}
