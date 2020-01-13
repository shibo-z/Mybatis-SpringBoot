package com.shibo.usersys.controller;

import com.github.pagehelper.PageInfo;
import com.shibo.usersys.pojo.TbUsers;
import com.shibo.usersys.service.TbUsersService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.shibo.usersys.utils.ResponsBo;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "用户管理Controller", tags = {"用户管理"})
public class TbUsersController {
    static final Logger logger = LoggerFactory.getLogger(TbUsersController.class);

    @Autowired
    TbUsersService usersService;

    @GetMapping("/select/all")
    @ApiOperation(value = "查询全部用户信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200,response = ResponsBo.class,message = "请求成功，操作成功/失败"),
            @ApiResponse(code = 404,message = "404错误")
    })
    public Object selectAll(){
        List<TbUsers> tbUsers = new ArrayList<>();
        ResponsBo responsBo;
        try {
            tbUsers = usersService.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("TbUsersController selectAll()", e);
            responsBo=new ResponsBo(false,null,"异常");
        }
        responsBo=new ResponsBo(true,tbUsers,"成功");
        return responsBo;
    }

    @GetMapping("/select")
    @ApiOperation(value = "查询用户信息,支持多条件和分页")
    @ApiResponses(value = {
            @ApiResponse(code = 200,response = ResponsBo.class,message = "请求成功，操作成功/失败"),
            @ApiResponse(code = 404,message = "404错误")
    })
    public Object selectFor(@ApiParam(value = "查询条件封装的TbUsers实体",required = false) @RequestParam(name = "tbUsers", required = false) TbUsers tbUsers,
                            @ApiParam(value = "当前页码",required = false,defaultValue = "1") @RequestParam(name = "pageNum", defaultValue = "1")String pageNum,
                            @ApiParam(value = "页大小",required = false,defaultValue = "10") @RequestParam(name = "pageSize", defaultValue = "10")String pageSize){
        PageInfo<TbUsers> tbUserListInfo = new PageInfo<>();
        ResponsBo responsBo;
        try {
            tbUserListInfo = usersService.select(tbUsers, pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("TbUsersController selectFor()", e);
            responsBo=new ResponsBo(false,null,"异常");
        }
        responsBo=new ResponsBo(true,tbUserListInfo,"成功");
        return responsBo;
    }

    @PostMapping("/insert")
    @ApiOperation(value = "插入一条用户信息,要求表为id自增")
    @ApiImplicitParam(name = "tbUsers",value = "用户实体",dataType = "TbUsers",paramType = "query",required = true)
    @ApiResponses(value = {
            @ApiResponse(code = 200,response = ResponsBo.class,message = "请求成功，操作成功/失败"),
            @ApiResponse(code = 404,message = "404错误")
    })
    public Object insertUseGeneratedKeys(@ApiParam(value = "查询条件封装的TbUsers实体",required = true) @RequestParam TbUsers tbUsers){
        ResponsBo responsBo;
        int insert = usersService.insertUseGeneratedKeys(tbUsers);
        if(insert > 0){
            responsBo=new ResponsBo(true,insert,"成功");
        }else{
            responsBo=new ResponsBo(false,null,insert == 0 ? "失败" : "异常");
        }
        return responsBo;
    }

    @GetMapping("/delete/{id}")
    @ApiOperation(value = "根据id物理删除一条用户信息")
    @ApiImplicitParam(name = "id",value = "用户id",dataType = "String",paramType = "path",required = true)
    @ApiResponses(value = {
            @ApiResponse(code = 200,response = ResponsBo.class,message = "请求成功，操作成功/失败"),
            @ApiResponse(code = 404,message = "404错误")
    })
    public Object delete(@PathVariable(name = "id") String id){
        ResponsBo responsBo;
        int delete = usersService.deleteByPrimaryKey(id);
        if(delete > 0){
            responsBo=new ResponsBo(true,delete,"成功");
        }else{
            responsBo=new ResponsBo(false,null,delete == 0 ? "失败" : "异常");
        }
        return responsBo;
    }

    @PostMapping("/update")
    //swagger标注接口
    @ApiOperation(value = "根据id修改一条用户信息")
    //swagger 参数说明注解
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "tbUsers",value = "参数封装的TbUsers实体s",dataType = "TbUsers",paramType = "query",required = true),
            @ApiImplicitParam(name = "isFullOverride",value = "表是否被参数完全覆盖s",dataType = "String",paramType = "query",defaultValue = "false",required = false)
    })
    //swagger 返回值说明
    @ApiResponses(value = {
            @ApiResponse(code = 200,response = ResponsBo.class,message = "请求成功，操作成功/失败"),
            @ApiResponse(code = 404,message = "404错误")
    })
    public Object update(@RequestParam TbUsers tbUsers , @RequestParam(name = "isFullOverride", required = false, defaultValue = "false") String isFullOverride){
        ResponsBo responsBo;
        int updateNum = 0;
        if (Boolean.valueOf(isFullOverride)) {
            updateNum = usersService.updateByPrimaryKey(tbUsers);
        }else{
            updateNum = usersService.updateByPrimaryKeySelective(tbUsers);
        }
        if(updateNum > 0){
            responsBo=new ResponsBo(true,updateNum,"成功");
        }else{
            responsBo=new ResponsBo(false,null,updateNum == 0 ? "失败" : "异常");
        }
        return responsBo;
    }

}
