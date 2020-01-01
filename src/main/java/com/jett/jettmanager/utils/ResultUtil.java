package com.jett.jettmanager.utils;

import com.jett.jettmanager.vo.ResultVo;

public class ResultUtil {

    // 请求成功返回数据格式统一封装
    public static ResultVo success(Object object){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMessage("success");
        resultVo.setData(object);
        return resultVo;
    }
}
