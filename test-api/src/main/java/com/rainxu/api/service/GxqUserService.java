package com.rainxu.api.service;

import com.rainxu.api.mapper.GxqUserMapper;
import com.rainxu.common.entity.user.GxqUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuxiaoyu on 17/8/24.
 */
@Service
public class GxqUserService {

    @Autowired
    private GxqUserMapper gxqUserMapper;

    private Logger logger = LoggerFactory.getLogger(GxqUserService.class);

    public GxqUser getUserListByUid(Long uid){
        logger.info("GxqUserService:" + uid);
        return gxqUserMapper.getUserInfoByUid(uid);
    }
}
