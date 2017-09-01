package com.rainxu.api.mapper;

import com.rainxu.common.bean.AbstractMapper;
import com.rainxu.common.entity.user.GxqUser;
import org.springframework.stereotype.Repository;

/**
 * Created by xuxiaoyu on 17/8/23.
 */
@Repository
public class GxqUserMapper extends AbstractMapper {

    public GxqUser getUserInfoByUid(Long uid){
        return sqlSession.selectOne("com.rainxu.api.mapper.GxqUserMapper.selectUsers", uid);
    }
}
