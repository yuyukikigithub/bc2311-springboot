package com.vtnlab.bootcamp.bootcampsbforum.infra;

import com.fasterxml.jackson.annotation.JsonInclude;

// import lombok.Builder;
// import lombok.Getter;

// @Builder
// @Getter

// ApiResp is for serialization, getter & setter are required
// for deserialization (restTemplate call -> objecMapper), only getter is required
// for deserialization (controller(spring) -> objecMapper), no getter & setter is required

//restTemplate.getForObject() is similar to redisHelper.get()

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResp<T> {
    private String code;

    private String message;

    private T data; // e at all kind of json

    public ApiResp (ApiRespBuilder<T> builder){
        this.code=builder.code;
        this.message=builder.message;
        this.data=builder.data;
    } 

    public static <T> ApiRespBuilder<T> builder(){
        return new ApiRespBuilder<>();
    }

    public static class ApiRespBuilder<T> {
        private String code ;
        private String message ;
        private T data;
        // chain method
        public ApiRespBuilder<T> code(String code){
            this.code=code;
            return this;
        }

        public ApiRespBuilder<T> message(String message){
            this.message=message;
            return this;
        }

        public ApiRespBuilder<T> status(Syscode syscode){
            this.code = syscode.getCode();
            this.message=syscode.getMessage();
            return this;
        }

        public ApiRespBuilder<T> ok(){
            this.code=Syscode.OK.getCode();
            this.message=Syscode.OK.getMessage();
            return this;
        }

        public ApiRespBuilder<T> concatCustomMessage(String customMessage){
            if (this.code==null||this.message==null||customMessage.isBlank()) {
                throw new RuntimeException();
            }
            this.message=this.message.concat("-").concat(customMessage);
            return this;
        }

        public ApiRespBuilder<T> data(T data){
            this.data=data;
            return this;
        }
        public ApiResp<T> build(){
            return new ApiResp<>(this);
        }

    }

    public static void main(String[] args) {
        ApiResp<String> apiRes = ApiResp.<String>builder()
                                    .code(Syscode.OK.getCode())
                                    .message(Syscode.OK.getMessage())
                                    .data("hwohe").build();

        ApiResp<String> apisdf = ApiResp.<String>builder()
                                    // .ok()
                                    .status(Syscode.OK)
                                    .data("oskdn").build();
    }
    
}
