package com.example.springbootmp.bo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @author BCY
 */
@Data
public class HelloDTO {

    @NotNull(message = "不可为空")
    private String hello;

    private Map<String , Object> map;
}
