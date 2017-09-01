package com.rainxu.common.entity.user;

/**
 * Created by xuxiaoyu on 17/8/24.
 */
public class GxqUser implements java.io.Serializable {
    private Long uid;
    private String phone;

    @Override
    public String toString(){
        return "GxqUser{" +
                "uid=" + uid +
                "phone=" + phone +
                "}";
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
