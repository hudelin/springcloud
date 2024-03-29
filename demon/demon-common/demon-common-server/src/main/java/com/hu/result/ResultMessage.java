package com.hu.result;

import com.hu.exception.DefaultSuccessMsgEnum;
import com.hu.exception.ErrorMsgEnum;
import lombok.Data;

/**
 * @author : hudelin
 * @className :ResultMessage
 * @description : 统一返回类型
 * @date: 2020-06-30 15:25
 */
@Data
public class ResultMessage<T> {

    private static DefaultSuccessMsgEnum successMsgEnum = DefaultSuccessMsgEnum.SUCCESS;
    private static ErrorMsgEnum errorMsgEnum = ErrorMsgEnum.FAIL;


    /**
     * code
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;

    /**
     * 视图数据
     */
    private T data;

    /**
     * 私有化构造器
     */
    private ResultMessage(){

    }


    /**
     * 成功
     * @return
     */
    public static ResultMessage success(){
        ResultMessage message=new ResultMessage();
        message.setCode(successMsgEnum.getCode());
        message.setMessage(successMsgEnum.getMsg());
        return message;
    }

    /**
     * 成功
     * @return
     */
    public static<T> ResultMessage<T> success(T data){
        ResultMessage<T> message=new ResultMessage<>();
        message.setCode(successMsgEnum.getCode());
        message.setMessage(successMsgEnum.getMsg());
        message.setData(data);
        return message;
    }

    /**
     * 失败
     * @return
     */
    public static ResultMessage fail(){
        ResultMessage message=new ResultMessage();
        message.setCode(errorMsgEnum.getCode());
        message.setMessage(errorMsgEnum.getMsg());
        return message;
    }

    /**
     * 构建自定义信息
     * @param code
     * @param msg
     * @return
     */
    public static ResultMessage build(Integer code, String msg){
        ResultMessage message=new ResultMessage<>();
        message.setCode(code);
        message.setMessage(msg);
        return message;
    }

//    /**
//     * 构建自定义信息
//     * @param code
//     * @param msg
//     * @return
//     */
//    public static<T> ResultMessage<T> build(Integer code, String msg, T data){
//        ResultMessage<T> message=new ResultMessage<>();
//        message.setCode(code);
//        message.setMessage(msg);
//        message.setData(data);
//        return message;
//    }

    /**
     * 返回信息
     * @param message
     * @return
     */
    public ResultMessage<T> message(String message){
        this.setMessage(message);
        return this;
    }

}
