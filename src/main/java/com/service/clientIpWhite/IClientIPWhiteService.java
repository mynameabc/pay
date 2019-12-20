package com.service.clientIpWhite;

import com.dto.ClientIPWhiteDTO;
import com.utils.Result;

public interface IClientIPWhiteService {

    Result checkIP(String ip, long merchantNo);

    Object getPageInfo(ClientIPWhiteDTO clientIPWhiteDTO);
}
