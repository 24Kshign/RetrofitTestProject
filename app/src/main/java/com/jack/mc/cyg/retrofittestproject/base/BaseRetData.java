package com.jack.mc.cyg.retrofittestproject.base;

/**
 * Gson返回Ret基本格式
 * 成功:ret=1 + 业务数据
 * 失败:ret=0 + err_code + err_msg
 * Created by tsy on 16/7/21.
 */
public class BaseRetData {
    public int status;         //成功1 失败0
    public String msg;  //错误msg
}
