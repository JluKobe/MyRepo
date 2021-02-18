package com.enums;

public enum DBTypeEnum {
    DB1("db1"), DB2("db2"), DB3("db3");
    private String value;
    DBTypeEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
