
##### SpringCloud Hoxton & SpringCloud Alibaba 学习过程记录

- [Bilibili-尚硅谷2020最新版SpringCloud(H版&alibaba)框架开发教程全套完整版从入门到精通(大牛讲授spring cloud)](https://www.bilibili.com/video/BV18E411x7eT/)

- [我的 SpringCloud 博客](https://zsy0216.github.io/docs/#/springcloud/)

- [各软件和脑图查看目录 `source-files` ](https://github.com/zsy0216/cloud2020/tree/master/source-files)

#### Eureka 集群修改 host 文件
找到C:\Windows\System32\drivers\etc路径下的hosts文件,添加
```shell script
127.0.0.1 eureka7001.com
127.0.0.1 eureka7002.com
```

#### 安装 Zookeeper 注册中心
[Linux 环境安装 Zookeeper](https://blog.csdn.net/Ep_Little_prince/article/details/102628696)

#### 安装 Consul 注册中心
文件夹 `source-files` 解压
```shell script
# 双击 .exe 文件启动
consul agent -dev
```

