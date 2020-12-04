package mybatis.mapper;

import mybatis.vo.entity.Player;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PlayerMapper extends BaseMapper<Player> {
}
