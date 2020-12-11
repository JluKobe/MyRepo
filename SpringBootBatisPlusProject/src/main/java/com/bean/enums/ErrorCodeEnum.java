package com.bean.enums;

public enum ErrorCodeEnum {
    GL000000("000000", "成功"),
    GL999999("999999", "失败"),
    GL099100("909100", "参数异常"),
    GL909401("909401", "无访问权限"),
    GL909500("909500", "未知异常"),
    GL909403("909403", "无权访问"),
    GL909404("909404", "找不到指定资源"),
    GL909001("909001", "网络超时"),
    GL909002("909002", "主键不能为空"),
    GL909003("909003", "查询失败"),
    GL909004("909004", "此记录不存在"),
    GL909005("909005", "更新失败"),
    GL909006("909006", "参数为空"),
    GL909007("909007", "插入失败"),
    GL909008("909008", "此记录已存在"),
    GL909009("909009", "删除失败"),
    GL999998("999998", "请稍后再试");

    private String code;
    private String message;

    public String message() {
        return this.message;
    }

    public String code() {
        return this.code;
    }

    private ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ErrorCodeEnum getEnum(int code) {
        ErrorCodeEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ErrorCodeEnum ele = var1[var3];
            if (ele.code().equals(code)) {
                return ele;
            }
        }
        return null;
    }
}
