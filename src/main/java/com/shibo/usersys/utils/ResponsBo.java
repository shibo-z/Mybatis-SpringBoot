package com.shibo.usersys.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ResponseBo",description = "统一返回的封装类")
public class ResponsBo {
    @ApiModelProperty(name = "success",value = "是否成功")
    Boolean success;
    @ApiModelProperty(name = "data",value = "请求得到的数据")
    Object data;
    @ApiModelProperty(name = "msg",value = "文字说明")
    String msg;

    public ResponsBo() {
    }

    public ResponsBo(Boolean success, Object data, String msg) {
        this.success = success;
        this.data = data;
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
