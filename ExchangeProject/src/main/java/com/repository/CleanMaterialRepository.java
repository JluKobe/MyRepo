package com.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bean.entity.clean.CleanMaterial;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CleanMaterialRepository extends BaseMapper<CleanMaterial> {
}
