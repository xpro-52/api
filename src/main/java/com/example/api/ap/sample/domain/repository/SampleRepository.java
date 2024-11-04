package com.example.api.ap.sample.domain.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.common.db.entity.Sample;

@Mapper
public interface SampleRepository {
    Optional<Sample> selectById(@Param("id") String id);

    List<Sample> selectAll();
}
