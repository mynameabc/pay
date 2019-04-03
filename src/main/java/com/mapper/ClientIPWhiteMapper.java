package com.mapper;

import com.MyMapper;
import com.entity.ClientIPWhite;
import org.apache.ibatis.annotations.Param;

public interface ClientIPWhiteMapper extends MyMapper<ClientIPWhite> {

    int getClientIPWhiteCount(@Param("clientIP") String clientIP, @Param("port") int port, @Param("merchantID") long merchantID);
}
