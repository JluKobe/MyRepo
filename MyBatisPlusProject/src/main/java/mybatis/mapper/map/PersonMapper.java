package mybatis.mapper.map;

import mybatis.vo.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PersonMapper {
    Person findById(@Param("id") Integer id);
}
