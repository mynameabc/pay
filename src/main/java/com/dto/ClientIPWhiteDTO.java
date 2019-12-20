package com.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientIPWhiteDTO {

    private String ipAddr;

    private long merchantNo;

    private String status;

    private String type;
}
