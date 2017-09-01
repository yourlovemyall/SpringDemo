package com.rainxu.common.bean;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.*;

import java.util.HashMap;
//import org.slf4j.Logger;
/**
 * Created by xuxiaoyu on 17/8/24.
 */
public class AbstractMapper {

    @Autowired
    protected SqlSession sqlSession;

    protected Logger logger = LoggerFactory.getLogger(AbstractMapper.class);

    protected Param setParameter(String key, Object value){ return new Param().setParameter(key, value);}

    protected static class Param extends HashMap<String, Object>{
        public Param setParameter(String key, Object value){
            put(key, value);
            return this;
        }
    }
}
