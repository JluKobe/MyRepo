package com.myproject.service;

import java.util.List;

public interface IDataExchange {
    boolean doBusiness(List<String> taskHandleItemList);

    boolean doBusiness2(String taskGuid);
}
