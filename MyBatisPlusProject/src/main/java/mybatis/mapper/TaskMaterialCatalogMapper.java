package mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mybatis.vo.entity.IgtTaskMaterialCatalog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TaskMaterialCatalogMapper extends BaseMapper<IgtTaskMaterialCatalog> {
}
