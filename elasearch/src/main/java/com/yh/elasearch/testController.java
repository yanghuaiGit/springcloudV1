package com.yh.elasearch;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@RestController
public class testController {


    @Autowired
    private RestHighLevelClient client;



    @GetMapping("/getdata")
    public SearchResponse get() {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.from(0);
        sourceBuilder.size(10);
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("orderNo", "201807240001");
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        boolBuilder.must(matchQueryBuilder);
        sourceBuilder.query(boolBuilder);
        SearchRequest searchRequest = new SearchRequest("buydeem");
        searchRequest.types("order");
        searchRequest.source(sourceBuilder);
        SearchResponse response =null;
        try {
             response = client.search(searchRequest);
            System.out.println(response);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

      return response;
    }

    @GetMapping ("/setdata")
    public void setdata() throws IOException {
        IndexRequest request = new IndexRequest("buydeem","order","1");
        Map<String,Object> order =new HashMap<>();
        order.put("orderNo","201807240001");
        order.put("created",new Date());
        order.put("amount", BigDecimal.TEN);
        request.source(order);
        IndexResponse response = client.index(request);
        System.out.println(response.toString());
    }






}
