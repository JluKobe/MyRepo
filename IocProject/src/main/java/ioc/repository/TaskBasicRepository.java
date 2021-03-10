package ioc.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ioc.bean.IgtTaskBasic;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskBasicRepository extends BaseMapper<IgtTaskBasic> {
}
