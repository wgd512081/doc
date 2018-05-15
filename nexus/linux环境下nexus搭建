使用nexus搭建maven私服及使用
=====

### nexus简介
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在开发过程中，有时候会使用到公司内部的一些开发包，显然把这些包放在外部是不合适的。另外，Maven默认提供的中央仓库是在远程网络服务Appache提供的，这对于我们开发时不合理的。如果我们没网了或者其他情况，我们怎么办？也就是说我们对中央仓库的依赖性太大。而Nexus私服则可以解决我们这个问题。先看下这张图应该就非常明白了。![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/nexusConstructure.png)
这样就相当于在我们本地的局域网搭建了一个类似中央仓库的服务器，我们开始将中央仓库的一些资料下载到私服务器上，然后平时我们的maven项目就是直接访问局域网内的私服即可，既节省了网络带宽也会加速项目搭建的进程，这样对我们开发来说，对公司来说都是非常好的选择。

-------------------

###Nexus下载及安装配置
我们可以在nexus的官网上找到它的相关介绍，下载地址是：http://www.sonatype.org/nexus/go

* 下载
```
 # wget https://sonatype-download.global.ssl.fastly.net/nexus/oss/nexus-2.11.2-03-bundle.tar.gz
```

* 解压
```
 cd /usr/local 
 mkdir nexus
 tar -xzvf nexus-2.11.2-03-bundle.tar.gz -C nexus
 cd nexus
 ls
 nexus-2.11.2-03   sonatype-work
```

* 修改配置文件

```
 cd nexus-2.11.2-03/conf
 vi nexus.properties
 #Jetty section
 application-port=8081      ##修改Jetty端口号
 # nexus section
 nexus-work=${bundleBasedir}/../sonatype-work/nexus
```　
* 编辑 nexus 脚本, 配置 RUN_AS_USER 参数

```
[root@localhost conf]# vi /usr/nexus/nexus-2.11.2-03/bin/nexus
NEXUS_HOME=".."
改为（不修改默认也可以）：
NEXUS_HOME="nexus安装目录"
RUN_AS_USER=
改为：
RUN_AS_USER=root
```

* 防火墙中打开 8081 端口 [etc目录通常放一些零散的配置文件]

```
[root@localhost conf]# vi /etc/sysconfig/iptables
添加：
-A INPUT -m state --state NEW -m tcp -p tcp --dport 8081 -j ACCEPT
启动nexus
/usr/local/nexus/nexus-2.11.2-03/bin ./nexus start
 \****************************************
WARNING - NOT RECOMMENDED TO RUN AS ROOT
\****************************************
Starting Nexus OSS...
Started Nexus OSS.
```

* 在浏览器打开:http://ip:8081/nexus,登录：用户名admin  默认密码：admin123
###查看nexus启动日志

```
/usr/local/nexus/nexus-2.11.2-03/logs
vi wrapper.loga
```

###安装过程中出现问题以及解决办法
* 问题：启动nexus的时候出现Name or service not known

```
vi /etc/hosts
我们可以看到nexus.codehaus.org没有配置在该文件内：
127.0.0.1   localhost localhost.localdomain localhost4 localhost4.localdomain4
::1         localhost localhost.localdomain localhost6 localhost6.localdomain6
将nexus.codehaus.org添加到/etc/hosts文件内，如
127.0.0.1   localhost localhost.localdomain localhost4 localhost4.localdomain4 nexus.codehaus.org
::1         localhost localhost.localdomain localhost6 localhost6.localdomain6 nexus.codehaus.org
```

###Nexus 验证
启动nexus后，在本机浏览器输入地址： http://ip:8081/nexus

&nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/nexus.png)

出现上述页面，说明配置nexus成功！
点击右上角“Log in”， 输入用户名和密码（默认用户名：admin      密码： admin123
###nexus使用
#####1.进入Repositories

 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/enterRepository.png)



#####2.查看分配给public组的仓库

 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/groupOfPublic.png)


#####3.修改仓库central下载连接、设置远程下载索引为true 
 
 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/centralModify.png)
 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/repariIndex.png)

#####4.显示In Service后可以使用
 
 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/inservice.png)

#####5.pom.xml配置jar包下载 

 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/dependency.png)
 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/ideaDependciesShow.png)

#####6.查看私服仓库下载的jar包
 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/checkNexusJar.png)

#####7.添加自己的jar到nexus
* 1.选中 3rd party , Artifact Upload 标签
  &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/3rd.png)

 * 2.在artifact Upload界面显示的有GAV Parameter,groupId,artifactId,Version,Packaging等等参数
  &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/gavd.png)

 * 3.将以上参数填完之后，选择要上传的jar包，点击”add artifact“,最后点击”uploadAtifact(s)“保存
 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/jarUpload.png)

 * 4.查看上传的jar包
 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/checkUploadContent.png)



