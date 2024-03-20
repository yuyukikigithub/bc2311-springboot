package com.vtnlab.bootcamp.bootcampsbforum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.vtnlab.bootcamp.bootcampsbforum.infra.BcUtil;
import com.vtnlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtnlab.bootcamp.bootcampsbforum.service.PostService;

public class PostJsonPlaceHolder  implements PostService{

    @Value(value="${api.jph.domain}")
    private String domain;

    @Value(value="${api.jph.endpoints.post}")
    private String postEndpoint;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Post> getPostsFromJPH() {
        String postUrl = BcUtil.url(Scheme.HTTPS, domain, postEndpoint);

        Post[] posts = restTemplate.getForObject(postUrl, Post[].class);
        return Arrays.stream(posts).collect(Collectors.toList());
    
    }
    
}
