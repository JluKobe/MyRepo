package com.enums;

public enum ConstantEnum {

    PRODUCT_SOURCE_TYPE("01", "产品来源机构，默认01"),

    PRODUCT_TYPE("01", "产品分类，默认01"),

    TASK_STATUS("1", "产品状态，默认1"),

    RESULT_SAMPLE(null, "审批结果样本"),

    TASK_AREA(null, "业务办理项归属区划"),

    BY_SUPPPOSE(null, "补充依据"),

    IS_REUSED("0", "是否可复用，默认0");

    private String code;
    private String message;

    public String message() {
        return this.message;
    }

    public String code() {
        return this.code;
    }

    ConstantEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
