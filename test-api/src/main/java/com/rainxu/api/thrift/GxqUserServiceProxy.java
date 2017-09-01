package com.rainxu.api.thrift;

import com.rainxu.api.protocol.TGetUserInfoResult;
import com.rainxu.api.protocol.TUserInfo;
import com.rainxu.api.protocol.UserService;
import com.rainxu.api.service.GxqUserService;
import com.rainxu.common.entity.user.GxqUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuxiaoyu on 17/8/25.
 */
@Service
public class GxqUserServiceProxy implements UserService.Iface {

    @Autowired
    private GxqUserService gxqUserService;

    @Override
    public TGetUserInfoResult getUserInfo(long uid){
        TGetUserInfoResult res = new TGetUserInfoResult();
        TUserInfo userinfo = new TUserInfo();
        GxqUser gxqUser = gxqUserService.getUserListByUid(uid);
        userinfo.setUid(gxqUser.getUid());
        userinfo.setPhone(gxqUser.getPhone());
        res.setData(userinfo);
        return res;
    }
}
