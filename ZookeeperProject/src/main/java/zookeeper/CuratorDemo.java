package zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

/**
 * 客户端的curator连接demo
 */
public class CuratorDemo {
    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.
                builder().connectString("192.168.58.131:2181," +
                "192.168.58.132:2181,192.168.58.133:2181").
                sessionTimeoutMs(4000).retryPolicy(new
                ExponentialBackoffRetry(1000,3)).
                namespace("").build();
        curatorFramework.start();
        Stat stat = new Stat();
        //查询节点数据
        byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath("/config/topics/test");
        System.out.println(new String(bytes));
        curatorFramework.close();
    }
}
