package com.service;

import com.bean.response.ExchangeTaskHandleItemResponse;
import com.bean.vo.ExchangeTaskHandleItemVo;

public interface IDataExchange {
    ExchangeTaskHandleItemResponse doBusiness(ExchangeTaskHandleItemVo vo);

    void myTest(ExchangeTaskHandleItemVo vo);
}
