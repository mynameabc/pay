package com.service.clientIpWhite;

import com.utils.Result;

public interface IClientIPWhiteService {

    Result checkIP(String ip, long merchantNo);
}
