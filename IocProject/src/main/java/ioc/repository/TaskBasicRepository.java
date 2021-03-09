package ioc.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ioc.bean.IgtTaskBasic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Repository
@Mapper
public interface TaskBasicRepository extends BaseMapper<IgtTaskBasic> {
}
