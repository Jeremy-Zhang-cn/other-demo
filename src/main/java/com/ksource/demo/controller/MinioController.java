package com.ksource.demo.controller;

import com.ksource.demo.util.MinioUtils;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Zhang Dingjie
 * @date 2021/6/22
 * @Description
 */

@RestController
@RequestMapping(value = "/minio/")
public class MinioController {


	@PostMapping(value = "uploadFile")
	public String uploadFile(@RequestParam(name = "file") MultipartFile file, String bucketName) throws IOException, ErrorResponseException, InsufficientDataException, InternalException, InvalidResponseException, NoSuchAlgorithmException, XmlParserException, ServerException, InvalidKeyException {

		if (file.isEmpty()) return null;
		InputStream inputStream = file.getInputStream();
		String contentType = file.getContentType();
		long objKey = System.currentTimeMillis();
		return MinioUtils.uploadFile(bucketName, String.valueOf(objKey), inputStream, contentType);

	}


	@DeleteMapping(value = "deleteFile")
	public void deleteFile(@RequestParam(name = "bucketName") String bucketName, String objectKey) throws IOException, InvalidResponseException, InvalidKeyException, NoSuchAlgorithmException, ServerException, ErrorResponseException, XmlParserException, InsufficientDataException, InternalException {
		MinioUtils.deleteFile(bucketName, objectKey);
	}


	@GetMapping(value = "getSignedUrl")
	public String getSignedUrl(@RequestParam(name = "bucketName") String bucketName, @RequestParam(name = "objectKey") String objectKey, Integer expiresIn) throws IOException, InvalidResponseException, InvalidKeyException, NoSuchAlgorithmException, ServerException, ErrorResponseException, XmlParserException, InsufficientDataException, InternalException {
		return MinioUtils.getSignedUrl(bucketName, objectKey, expiresIn);
	}

}
