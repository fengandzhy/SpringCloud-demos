1. 服务注册register, 就是把自己的ip和端口注册给eureka 
2. 服务续约renew, 服务会每隔30秒给eureka发送心跳, 告诉eureka 自己还存在着. 
3. 服务的剔除 eviction, 超过90秒没有收到service发送的心跳, eureka会默认服务已经不存在, 会将服务剔除
4. 服务下线 cancel, provider 停止关闭, 调用eureka, 把自己从注册表中剔除 防止consumer调用不存在的服务
5. get registry(获取注册列表)
6 replicate eureka集群自己的数据同步和复制
