package com.capstone.AdminAuthen.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ResponseStatusDTO {

    private Integer code;
    private Map<String,Object> data;
    private  String message;
}
