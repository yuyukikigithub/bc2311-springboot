package com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User  {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
    
    @Getter
    @Setter
    public static class Company {
        private String name;
        private String catchPhrase;
        private String bs;
    }

    @Setter
    @Getter
    public static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;
    }

    @Setter
    @Getter
    public static class Geo {
        private String lat;
        private String lng;
        // @JsonProperty(value="lng")
        // private String langtitude;
    }

}
