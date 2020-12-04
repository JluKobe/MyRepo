package mybatis.service;

import mybatis.mapper.PlayerMapper;
import mybatis.mapper.map.PersonMapper;
import mybatis.vo.entity.Person;
import mybatis.vo.entity.Player;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@Service
public class MyBatisService extends ServiceImpl<PlayerMapper, Player> {

    @Autowired
    private PersonMapper mapper;

    public Player MyBatisTest() {
        //使用Wrappers
        Player player;
        player = baseMapper.selectOne(Wrappers.<Player>lambdaQuery().eq(Player::getId, "3"));
        return player;
    }

    public Person MyBatisTest2(Integer id) {
        //使用xml
        Person person = mapper.findById(id);
        return person;
    }
}
