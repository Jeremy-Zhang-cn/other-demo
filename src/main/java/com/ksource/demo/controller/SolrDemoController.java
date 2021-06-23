package com.ksource.demo.controller;

import com.ksource.demo.util.client.SingletonClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.MapSolrParams;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhang Dingjie
 * @date 2021/6/4
 * @Description
 */

@RestController
@RequestMapping(value = "/solr/")
public class SolrDemoController {

	private static final String BASE_SOLR_URL = "http://172.16.30.34:8983/solr/";
	private static final String CORE_NAME = "new_core";

	private static final HttpSolrClient SOLR_CLIENT = SingletonClient
			.SINGLETON_CLIENT.getSolrClient(BASE_SOLR_URL, CORE_NAME);


	@GetMapping(value = "add")
	public void add() throws IOException, SolrServerException {

		// 创建文档对象
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "aabcsse21x");
		document.addField("depart_name", "河南研发中心");

		SOLR_CLIENT.add(document);
		SOLR_CLIENT.commit();

	}

	@PutMapping(value = "update")
	public void upd() throws IOException, SolrServerException {
		// 创建文档对象
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "aabcsse21x");
		document.addField("depart_name", "河南营销中心");

		SOLR_CLIENT.add(document);
		SOLR_CLIENT.commit();
	}

	@GetMapping(value = "query")
	public void query() throws IOException, SolrServerException {

		SolrQuery query = new SolrQuery();
		query.set("q", "*:*");
		query.setRows(10);
		query.setStart(0);
		QueryResponse response = SOLR_CLIENT.query(query);
		SolrDocumentList results = response.getResults();
		long cnt = results.getNumFound();
		System.out.printf("共查询到%d条结果", cnt);
		for (SolrDocument result : results) {
			System.out.printf("id: %s, depart_name: %s, org_code: %s", result.get("id"), result.get("depart_name"), result.get("org_code"));
		}

	}

	@GetMapping
	public void queryParam() throws IOException, SolrServerException {
		Map<String, String> params = new HashMap<>(16);
		params.put("q", "*:*");
		MapSolrParams queryParams = new MapSolrParams(params);
		QueryResponse response = SOLR_CLIENT.query(queryParams);
		SolrDocumentList results = response.getResults();
		long cnt = results.getNumFound();
		System.out.printf("共查询到%d条结果", cnt);
		for (SolrDocument result : results) {
			System.out.printf("id: %s, depart_name: %s, org_code: %s", result.get("id"), result.get("depart_name"), result.get("org_code"));
		}
	}

	@DeleteMapping(value = "delete")
	public void del() throws IOException, SolrServerException {
		SOLR_CLIENT.deleteById("aabcsse21x");
		SOLR_CLIENT.commit();
	}

}
