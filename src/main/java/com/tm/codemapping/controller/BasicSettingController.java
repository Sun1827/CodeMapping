package com.tm.codemapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tm.codemapping.bean.ResultBean;
import com.tm.codemapping.common.ResultEnum;
import com.tm.codemapping.execption.ResultException;
import com.tm.codemapping.service.BasicSettingService;
import com.tm.codemapping.utils.ResultUtils;
import com.tm.codemapping.utils.StringUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/basicsetting")
@Api(tags = "基本信息操作")
public class BasicSettingController {

	 @Autowired BasicSettingService basicSettingService;
	 
	 @ApiOperation(value="新建建筑", notes="")
	 @ApiImplicitParam(name = "name", value = "建筑名称",paramType = "query", dataType = "String")
	 @RequestMapping(value="insertBuilding",method= RequestMethod.POST)
	 public ResultBean insertBuilding(String name) throws Exception {
		 if(StringUtils.isNullOrWhiteSpace(name)) {
			 throw new ResultException(ResultEnum.NOTNULL_ERROR);
		 }
		 basicSettingService.insertBuilding(name);
		 return ResultUtils.success();
	 }
	 
	 @ApiOperation(value="删除建筑", notes="")
	 @ApiImplicitParam(name = "id", value = "建筑id",paramType = "query", dataType = "String")
	 @RequestMapping(value="deleteBuilding",method= RequestMethod.POST)
	 public ResultBean deleteBuilding(String id) throws Exception {
		 if(StringUtils.isNullOrWhiteSpace(id)) {
			 throw new ResultException(ResultEnum.NOTNULL_ERROR);
		 }
		 basicSettingService.deleteBuilding(id);
		 return ResultUtils.success();
	 }
}
