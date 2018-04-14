package com.common.elasticsearch;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import com.alibaba.fastjson.JSON;
import com.common.pagehelper.Pages;


public class Es {

	// ����
	private static TransportClient client;
	// ���������ƣ�һ�㶼��һ���⣬ֻ����ߵ�type��ͬ
	private static final String index = "";
	
	private static String host=""; // ��������ַ
    private static int port=9300; // �˿�

	public Es() {
		try {
			Settings settings = Settings.builder().put("cluster.name", "my-application").build();
			client = new PreBuiltTransportClient(Settings.EMPTY)
	                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host),port));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Description: �ر�����
	 */
	public void close() {
		client.close();
	}

	/**
	 * 
	 * @Description: ��֤�����Ƿ�����
	 */
	public boolean validate() {
		return client.connectedNodes().size() == 0 ? false : true;
	}

	/**
	 * 
	 * @Description:����ĵ�
	 */
	public void addDoc(String type, Object id, Object object) {
		client.prepareIndex(index, type, id.toString()).setSource(JSON.toJSONString(object)).get();
	}

	/**
	 * 
	 * @Description:�����ĵ�
	 */
	public void updateDoc(String type, Object id, Object object) {
		client.prepareUpdate(index, type, id.toString()).setDoc(JSON.toJSONString(object)).get();
	}

	/**
	 * 
	 * @Description:ɾ���ĵ�
	 */
	public void delDoc(String type, Object id) {
		client.prepareDelete(index, type, id.toString()).get();
	}

	/**
	 * 
	 * @Description: ��ҳ������ѯ
	 * @param fields ��ѯ���ֶμ���
	 */
	public Pages getDocHighLight(String keywords, String type, Set<String> fields, int currentPage, int pageSize, boolean isHighlight) throws Exception {
		// ��������
		SearchResponse response = client.prepareSearch(index).setTypes(type)//
				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)//
				.setQuery(QueryBuilders.multiMatchQuery(keywords, fields.toArray(new String[fields.size()]))// ��ѯ�����ֶ�
						.analyzer("standard"))// �ִ���
				.highlighter(new HighlightBuilder().preTags("<span style=\"color:red\">").postTags("</span>").field("*"))// ������ǩ
				.setFrom((currentPage - 1) * pageSize).setSize(pageSize)// ��ҳ
				.setExplain(true)// ��������
				.execute().actionGet();

		// ��ȡ��ѯ�����
		SearchHits searchHits = response.getHits();
		List<Object> result = new ArrayList<Object>();
		// ����������
		for (SearchHit hit : searchHits) {
			Map<String, Object> source = hit.getSource();
			if (isHighlight) {
				// ��ȡ��Ӧ�ĸ�����
				Map<String, HighlightField> highlight = hit.getHighlightFields();
				for (String field : fields) {
					// ���趨�ĸ�������ȡ��ָ����
					HighlightField titleField = highlight.get(field);
					if (titleField == null) continue;
					// ȡ�ö���ĸ�����ǩ
					String texts = StringUtils.join(titleField.fragments());
					source.put(field, texts);
				}
				source.put("item",hit.getId());
			}
			result.add(source);
		}
		return new Pages(currentPage, pageSize, (int) searchHits.totalHits(), result);
	}

	/**
	 * 
	 * @Description: �ع�����(���´ʿ�֮��)
	 */
	public void reindex() {
		SearchResponse scrollResp = client.prepareSearch(index)//
				.setScroll(new TimeValue(60000))//
				.setQuery(QueryBuilders.matchAllQuery())//
				.setSize(100).get(); // max of 100 hits will be returned for
		// Scroll until no hits are returned
		do {
			for (SearchHit hit : scrollResp.getHits().getHits()) {
				client.prepareIndex(index, hit.getType(), hit.getId()).setSource(hit.getSourceAsString()).execute().actionGet();
			}
			scrollResp = client.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(60000)).execute().actionGet();
		} while (scrollResp.getHits().getHits().length != 0);
	}

}
