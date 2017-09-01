package com.rainxu.api.server.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xuxiaoyu on 17/8/24.
 */
public abstract class BaseThriftServer implements Runnable {

    private String ip;
    private int port;
    private String name;

    private Logger logger = LoggerFactory.getLogger(BaseThriftServer.class);

    protected abstract void startServer() throws Exception;
    public void run() {
        logger.info(this.name + "start ... ");
        try {
            this.startServer();
        }catch (Exception e){
            logger.error("start err.");
        }

    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
