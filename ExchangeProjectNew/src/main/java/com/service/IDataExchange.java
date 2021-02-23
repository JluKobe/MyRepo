package com.service;

import com.bean.response.ExchangeTaskHandleItemResponse;
import com.bean.vo.ExchangeTaskHandleItemVo;

public interface IDataExchange {
    //生产环境导入
    ExchangeTaskHandleItemResponse doBusinessProductionEnvironment(ExchangeTaskHandleItemVo vo);
}
