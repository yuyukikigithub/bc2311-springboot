package com.vtnlab.bootcamp.bootcampsbforum.infra;

import org.springframework.web.util.UriComponentsBuilder;

public class BcUtil {
    
    @SuppressWarnings("null")
    public static String url(Scheme scheme, String domain, String endpoint){
        return UriComponentsBuilder.newInstance() //
        .scheme(scheme.lowercaseName()) // .scheme("https")
        .host(domain) //
        .path(endpoint) //
        .toUriString(); // handle special character, such as : / \
    }
}
