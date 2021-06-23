package com.ksource.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @author Zhang Dingjie
 * @date 2021/6/11
 * @Description
 */
@RestController
@RequestMapping(value = "/encode/")
public class EncodeController {

	@PostMapping(value = "img2Base64")
	public String trans2Base64(@RequestParam(name = "file")MultipartFile file) throws IOException {

		byte[] bytes = file.getBytes();
		BASE64Encoder encoder = new BASE64Encoder();
		String encode = encoder.encode(bytes);
		encode = "data:image/png;base64," + encode;
		System.out.println(encode);
		return encode;

	}

}
