package com.vtnlab.bootcamp.bcproductdata.model.request;

import com.vtnlab.bootcamp.bcproductdata.model.Profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class ProfileReqDTO {
    String code;
    String message;
    Profile data;
}
