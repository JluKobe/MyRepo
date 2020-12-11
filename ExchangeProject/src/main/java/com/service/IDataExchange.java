package com.service;

import com.bean.response.ExchangeTaskHandleItemResponse;

import java.util.List;

public interface IDataExchange {
    ExchangeTaskHandleItemResponse doBusiness(List<String> taskHandleItemList, String isHighFrequency);
}
