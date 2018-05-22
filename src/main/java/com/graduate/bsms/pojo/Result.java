package com.graduate.bsms.pojo;

/**
 * 创建时间：2018年3月28日 下午8:45:20
 * 项目名称：bsms
 *
 * @author luomingjian
 * @version 1.0
 * @since JDK 1.6.0_21
 * 文件名称：Result.java
 * 类说明：  返回结果类statusCode的值为200：成功;400错误请求
 */
public class Result {
    private int statusCode;
    private String message;

    public Result() {
        super();
    }

    public Result(int statusCode, String message) {
        super();
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result [statusCode=" + statusCode + ", message=" + message + "]";
    }

}
