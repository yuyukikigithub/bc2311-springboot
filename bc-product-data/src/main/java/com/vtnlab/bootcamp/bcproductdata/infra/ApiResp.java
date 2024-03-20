package com.vtnlab.bootcamp.bcproductdata.infra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Getter
@Setter
public class ApiResp<T> {
    private String code;
    private String message;
    private T data;

    public String getCode(){
        return this.code;
    }

    public String message(){
        return this.message;
    }

    public T getData(){
        return this.data;
    }

    public static <T> ApiRespBuilder<T> builder(){
        return new ApiRespBuilder<>();
    }

    // private ApiResp(ApiRespBuilder<T> builder){
    //     retur
    // }

    public static class ApiRespBuilder<T> {

        private String code;
        private String message;
        private T data;



    }
    
}
