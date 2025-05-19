# 关于tomcat-debug

## 本地编译构建

```text
从github上下载所需版本的tomcat源码
按照根目录下BUILDING.txt文件的操作说明,进行本地编译构建
```

## 生成tomcat源码包

```text
为了方便debug tomcat时查看源码,需要自己手动生成一个jar格式的tomcat源码包

举例:
进入apache-tomcat-9.0.89-src目录,需要将org目录下的源码打包到jar包中,执行如下命令:
jar cf tomcat-9.0.89-src.jar -C java org
```



## 设置IDEA的remote jvm debug

```text
catalina.sh jpda start
catalina.bat jpda start
```
创建一个tomcat-debug模块,专门用来debug tomcat
在idea中随便打开一个tomcat的类,idea会提示choose source,然后关联tomcat-9.0.89-src.jar即可