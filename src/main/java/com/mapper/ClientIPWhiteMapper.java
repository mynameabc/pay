package com.mapper;

import com.MyMapper;
import com.entity.ClientIPWhite;
import org.apache.ibatis.annotations.Param;

public interface ClientIPWhiteMapper extends MyMapper<ClientIPWhite> {

    ClientIPWhite getClientIPWhite(@Param("clientIP") String clientIP, @Param("merchantID") long merchantID);
}
