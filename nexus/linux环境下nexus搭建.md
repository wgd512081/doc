ʹ��nexus�maven˽����ʹ��
=====

### nexus���
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�ڿ��������У���ʱ���ʹ�õ���˾�ڲ���һЩ����������Ȼ����Щ�������ⲿ�ǲ����ʵġ����⣬MavenĬ���ṩ������ֿ�����Զ���������Appache�ṩ�ģ���������ǿ���ʱ������ġ��������û���˻������������������ô�죿Ҳ����˵���Ƕ�����ֿ��������̫�󡣶�Nexus˽������Խ������������⡣�ȿ�������ͼӦ�þͷǳ������ˡ�![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/nexusConstructure.png)
�������൱�������Ǳ��صľ��������һ����������ֿ�ķ����������ǿ�ʼ������ֿ��һЩ�������ص�˽�������ϣ�Ȼ��ƽʱ���ǵ�maven��Ŀ����ֱ�ӷ��ʾ������ڵ�˽�����ɣ��Ƚ�ʡ���������Ҳ�������Ŀ��Ľ��̣����������ǿ�����˵���Թ�˾��˵���Ƿǳ��õ�ѡ��

-------------------

###Nexus���ؼ���װ����
���ǿ�����nexus�Ĺ������ҵ�������ؽ��ܣ����ص�ַ�ǣ�http://www.sonatype.org/nexus/go

* ����
```
 # wget https://sonatype-download.global.ssl.fastly.net/nexus/oss/nexus-2.11.2-03-bundle.tar.gz
```

* ��ѹ
```
 cd /usr/local 
 mkdir nexus
 tar -xzvf nexus-2.11.2-03-bundle.tar.gz -C nexus
 cd nexus
 ls
 nexus-2.11.2-03   sonatype-work
```

* �޸������ļ�

```
 cd nexus-2.11.2-03/conf
 vi nexus.properties
 #Jetty section
 application-port=8081      ##�޸�Jetty�˿ں�
 # nexus section
 nexus-work=${bundleBasedir}/../sonatype-work/nexus
```��
* �༭ nexus �ű�, ���� RUN_AS_USER ����

```
[root@localhost conf]# vi /usr/nexus/nexus-2.11.2-03/bin/nexus
NEXUS_HOME=".."
��Ϊ�����޸�Ĭ��Ҳ���ԣ���
NEXUS_HOME="nexus��װĿ¼"
RUN_AS_USER=
��Ϊ��
RUN_AS_USER=root
```

* ����ǽ�д� 8081 �˿� [etcĿ¼ͨ����һЩ��ɢ�������ļ�]

```
[root@localhost conf]# vi /etc/sysconfig/iptables
��ӣ�
-A INPUT -m state --state NEW -m tcp -p tcp --dport 8081 -j ACCEPT
����nexus
/usr/local/nexus/nexus-2.11.2-03/bin ./nexus start
 \****************************************
WARNING - NOT RECOMMENDED TO RUN AS ROOT
\****************************************
Starting Nexus OSS...
Started Nexus OSS.
```

* ���������:http://ip:8081/nexus,��¼���û���admin  Ĭ�����룺admin123
###�鿴nexus������־

```
/usr/local/nexus/nexus-2.11.2-03/logs
vi wrapper.loga
```

###��װ�����г��������Լ�����취
* ���⣺����nexus��ʱ�����Name or service not known

```
vi /etc/hosts
���ǿ��Կ���nexus.codehaus.orgû�������ڸ��ļ��ڣ�
127.0.0.1   localhost localhost.localdomain localhost4 localhost4.localdomain4
::1         localhost localhost.localdomain localhost6 localhost6.localdomain6
��nexus.codehaus.org��ӵ�/etc/hosts�ļ��ڣ���
127.0.0.1   localhost localhost.localdomain localhost4 localhost4.localdomain4 nexus.codehaus.org
::1         localhost localhost.localdomain localhost6 localhost6.localdomain6 nexus.codehaus.org
```

###Nexus ��֤
����nexus���ڱ�������������ַ�� http://ip:8081/nexus

&nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/nexus.png)

��������ҳ�棬˵������nexus�ɹ���
������Ͻǡ�Log in���� �����û��������루Ĭ���û�����admin      ���룺 admin123
###nexusʹ��
#####1.����Repositories

 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/enterRepository.png)



#####2.�鿴�����public��Ĳֿ�

 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/groupOfPublic.png)


#####3.�޸Ĳֿ�central�������ӡ�����Զ����������Ϊtrue 
 
 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/centralModify.png)
 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/repariIndex.png)

#####4.��ʾIn Service�����ʹ��
 
 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/inservice.png)

#####5.pom.xml����jar������ 

 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/dependency.png)
 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/ideaDependciesShow.png)

#####6.�鿴˽���ֿ����ص�jar��
 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/checkNexusJar.png)

#####7.����Լ���jar��nexus
* 1.ѡ�� 3rd party , Artifact Upload ��ǩ
  &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/3rd.png)

 * 2.��artifact Upload������ʾ����GAV Parameter,groupId,artifactId,Version,Packaging�ȵȲ���
  &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/gavd.png)

 * 3.�����ϲ�������֮��ѡ��Ҫ�ϴ���jar���������add artifact��,�������uploadAtifact(s)������
 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/jarUpload.png)

 * 4.�鿴�ϴ���jar��
 &nbsp;&nbsp;![enter image description here](https://github.com/wgd512081/doc/raw/master/picture/checkUploadContent.png)



