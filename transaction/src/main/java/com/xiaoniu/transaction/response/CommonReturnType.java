package com.xiaoniu.transaction.response;

public class CommonReturnType {
    //表面对应的请求的返回处理结果"success"或"fail"
    private String status;

    //若status=success,则data内返回前端需要的json数据
    //若status=fail，则data内返回通用的错误代码格式
    private Object data;

    //定义一个通用的创建方法
    public static CommonReturnType create(Object object) {
        return CommonReturnType.create(object, "success");
    }

    public static CommonReturnType create(Object object, String status) {
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setData(object);
        commonReturnType.setStatus(status);
        return commonReturnType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
