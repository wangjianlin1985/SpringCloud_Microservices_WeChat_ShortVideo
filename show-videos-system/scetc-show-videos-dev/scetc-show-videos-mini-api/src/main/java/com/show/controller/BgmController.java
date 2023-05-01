package com.show.controller;

import com.show.pojo.Bgm;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.show.service.BgmService;
import com.show.utils.XyfJsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/bgm")
@Api(value = "背景音乐", tags = { "背景音乐业务controller" })
public class BgmController {
	@Autowired
	private BgmService bgmService;
	@ApiOperation(value = "列表", notes = "获取背景音乐列表")
	@PostMapping("/list")
	public XyfJsonResult list() {
		
		return XyfJsonResult.ok(bgmService.queryBgmList());
	}
	@ApiOperation(value = "列表", notes = "获取视频分类列表")
	@PostMapping("/listVideoCategory")
	public XyfJsonResult listVideoCategory() {
		
		return XyfJsonResult.ok(bgmService.queryBgmList());
	}

	// 保存用户的评论到数据库
	@PostMapping(value = "/queryBgmById")
	public XyfJsonResult queryBgmId(String audioId) {
		Bgm bgm = bgmService.queryBgmById(audioId);
		return XyfJsonResult.ok(bgm);// 返回当前视频的所有评论
	}

	
}
