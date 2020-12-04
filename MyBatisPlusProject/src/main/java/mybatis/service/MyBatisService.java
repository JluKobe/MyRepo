package mybatis.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import mybatis.mapper.PlayerMapper;
import mybatis.mapper.map.PersonMapper;
import mybatis.vo.entity.Person;
import mybatis.vo.entity.Player;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.List;

@Service
public class MyBatisService extends ServiceImpl<PlayerMapper, Player> {

    @Autowired
    private PersonMapper mapper;

    //使用Wrappers，不用xml
    public Player queryByIdUseWrappers(Integer id) {
        Player player;
        player = baseMapper.selectOne(Wrappers.<Player>lambdaQuery().eq(Player::getId, id));
        return player;
    }

    //使用xml
    public Person queryByIdUseXml(Integer id) {
        Person person = mapper.findById(id);
        return person;
    }

    public Player queryByIdAndNameUseWrappers(Integer id, String name) {
        Player player;
        player = baseMapper.selectOne(Wrappers.<Player>lambdaQuery().eq(Player::getId, id).eq(Player::getName, name));
        return player;
    }

    //查询所有数据
    public List<Player> queryAllData() {
        List<Player> playerList = baseMapper.selectList(Wrappers.<Player>lambdaQuery());
        return playerList;
    }

    //like模糊查询 like %name% 情况
    public List<Player> queryLikeName(String name) {
        List<Player> playerList = baseMapper.selectList(Wrappers.<Player>lambdaQuery().like(Player::getName, name));
        return playerList;
    }

    //like模糊查询 like %name% 情况
    public List<Player> queryLikeLeftName(String name) {
        List<Player> playerList = baseMapper.selectList(Wrappers.<Player>lambdaQuery().likeLeft(Player::getName, name));
        return playerList;
    }
}
