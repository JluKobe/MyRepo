package mybatis.mapper.map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mybatis.vo.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 继承BaseMapper
 */

@Mapper
@Repository
public interface PersonMapperEx extends BaseMapper<Person> {
}
