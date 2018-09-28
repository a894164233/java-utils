package com.baitao.javautils.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baitao
 * @date 2018/9/28 13:35
 */
@RestController("user")
public class UserController {

	@GetMapping("name")
	public String index1() {
		return "hello world 12345";
	}
}
