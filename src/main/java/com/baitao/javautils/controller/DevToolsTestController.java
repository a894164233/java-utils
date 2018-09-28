package com.baitao.javautils.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baitao
 * @date 2018/9/28 13:35
 */
@RestController("test")
public class DevToolsTestController {

	@GetMapping
	public String index() {
		return "hello world 123456";
	}
}
