package com.service;

import com.bean.response.ExchangeTaskHandleItemResponse;
import com.bean.vo.ExchangeTaskHandleItemVo;

public interface IDateExchangeNew {

    /**
     * 准生产环境，数据导入 igt_task_v1 新表
     * @param vo
     * @return
     */
    ExchangeTaskHandleItemResponse doBusiness(ExchangeTaskHandleItemVo vo);
}
