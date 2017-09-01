package com.rainxu.api.server.base;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.TProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;

/**
 * Created by xuxiaoyu on 17/8/24.
 */
public class MultiThriftServer extends BaseThriftServer {

    private Logger logger = LoggerFactory.getLogger(MultiThriftServer.class);
    private final int mMaxWorkerThreads;

    private final Map<String, TProcessor> serverMap;

    public MultiThriftServer(String serverName, String ip, int port, Map<String, TProcessor> serverMap, int mMaxWorkerThreads){
        this.setName(serverName);
        this.mMaxWorkerThreads = mMaxWorkerThreads;
        this.setIp(ip);
        this.setPort(port);
        this.serverMap = serverMap;
        try {
            this.startServer();
        }catch (Exception e){
            logger.error("MultiThriftServer start err.");
        }

    }

    public void startServer() throws Exception{
        TMultiplexedProcessor processor = new TMultiplexedProcessor();
        for (Map.Entry<String, TProcessor> entry : serverMap.entrySet()){
            processor.registerProcessor(entry.getKey(), entry.getValue());
        }

        InetSocketAddress socketAddress = new InetSocketAddress(this.getIp(), this.getPort());
        TServerTransport serverTransport = new TServerSocket(socketAddress);
        // create master thrift service with the multiplexed processor.
        TServer mMasterServiceServer = new TThreadPoolServer(
                new TThreadPoolServer.Args(serverTransport).maxWorkerThreads(mMaxWorkerThreads).processor(processor)
        );

        // start thrift rpc server
        mMasterServiceServer.serve();
    }
}
