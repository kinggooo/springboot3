package com.wangnz.zk.reg;

import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
@Component
public class ServiceRegistryImpl implements ServiceRegistry, Watcher {

    private static Logger log = LoggerFactory.getLogger(ServiceRegistryImpl.class);

    private static CountDownLatch latch = new CountDownLatch(1);

    private static final String REGISTRY_PATH = "/registry";

    private static final int SESSION_TIMEOUT = 5000;

    private ZooKeeper zk;

    public ServiceRegistryImpl(String zkServers) {
        try {
            zk = new ZooKeeper(zkServers, SESSION_TIMEOUT, this);
            latch.await();
            log.debug("connect to zookeeper");
        } catch (Exception e) {
            log.error("create zookeeper client failure", e);
        }
    }

    @Override
    public void register(String serviceName, String serviceAddress) {

        try {
            String registryPath = REGISTRY_PATH;
            if (zk.exists(registryPath, false) == null) {
                zk.create(registryPath, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                log.debug("create registry node: {}", registryPath);
            }

            String servicePath = registryPath + "/" + serviceName;
            if (zk.exists(servicePath, false) == null) {
                zk.create(servicePath, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                log.debug("create service node: {}", servicePath);
            }

            String addressPath = servicePath + "/address-";
            String addressNode = zk.create(addressPath, serviceAddress.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            log.debug("create address node: {} => {}", addressNode, serviceAddress);
        } catch (Exception e) {
            log.error("create node failure", e);
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            latch.countDown();
        }
    }
}
