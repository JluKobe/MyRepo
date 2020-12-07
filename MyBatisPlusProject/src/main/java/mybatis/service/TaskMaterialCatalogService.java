package mybatis.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import mybatis.mapper.TaskMaterialCatalogMapper;
import mybatis.vo.entity.IgtTaskMaterialCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskMaterialCatalogService {
    @Autowired
    private TaskMaterialCatalogMapper mapper;

    public int updateKeyPoint() {
        List<IgtTaskMaterialCatalog> igtTaskMaterialCatalogList = mapper.selectList(Wrappers.<IgtTaskMaterialCatalog>lambdaQuery());
        UUID uuid = null;
        for(IgtTaskMaterialCatalog igtTaskMaterialCatalog : igtTaskMaterialCatalogList) {
            uuid = UUID.randomUUID();
            igtTaskMaterialCatalog.setMaterialKeyPoint(uuid.toString());
            mapper.updateById(igtTaskMaterialCatalog);
        }

        return igtTaskMaterialCatalogList.size();
    }
}
