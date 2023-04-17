package com.issuetracker.engine.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @JsonProperty("userCode")
    private String userCode;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("userDepartment")
    private String userDepartment;
    @JsonProperty("userEmail")
    private String userEmail;
    @JsonProperty("userPhone")
    private String userPhone;

}
