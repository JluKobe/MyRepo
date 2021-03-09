package ioc.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import ioc.bean.IgtTaskBasic;
import ioc.repository.TaskBasicRepository;
import ioc.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private TaskBasicRepository taskBasicRepository;

    @Override
    public void saveAccount() {
        IgtTaskBasic igtTaskBasic = taskBasicRepository.selectOne(Wrappers.<IgtTaskBasic>lambdaQuery()
                .eq(IgtTaskBasic::getTaskHandleItem, "11220000412760890L200012001400001"));
        System.out.println(igtTaskBasic.getTaskName());
    }
}
