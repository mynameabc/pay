package com.mapper;

import com.MyMapper;
import com.pojo.entity.IPWhite;
import org.apache.ibatis.annotations.Param;

public interface ClientIPWhiteMapper extends MyMapper<IPWhite> {

    IPWhite getClientIPWhite(@Param("clientIP") String clientIP, @Param("merchantID") long merchantID);
}
