package com.mapper;

import com.MyMapper;
import com.entity.ClientIPWhite;

public interface ClientIPWhiteMapper extends MyMapper<ClientIPWhite> {

    int getClientIPWhiteCount(String clientIP, int port, long merchantID);
}
