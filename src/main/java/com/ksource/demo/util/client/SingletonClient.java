package com.ksource.demo.util.client;

import io.minio.MinioClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

/**
 * @author Zhang Dingjie
 * @date 2021/6/23
 * @Description 枚举获取单例模型
 */
public enum SingletonClient {

	SINGLETON_CLIENT;

	private MinioClient minioClient;
	private HttpSolrClient solrClient;

	public MinioClient getMinioClient(String endpoint, String accessKey, String secretKey) {
		return minioClient == null ?
						(minioClient = MinioClient.builder()
						.endpoint(endpoint)
						.credentials(accessKey, secretKey)
						.build()) : minioClient;
	}

	public HttpSolrClient getSolrClient(String baseUrl, String core) {
		return solrClient == null ?
				(solrClient = new HttpSolrClient
						.Builder(baseUrl+core).build()) : solrClient;
	}

}
