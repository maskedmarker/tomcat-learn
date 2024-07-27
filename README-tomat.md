# 关于tomcat的知识


## tomcat的架构设计
从conf/server.xml中的配置层级就可以看出大概的层次设计
<Server>
    <Service name="Catalina">
        <Connector port="9080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="9443" maxParameterCount="1000" />
        <Engine name="Catalina" defaultHost="localhost">
            <Host name="localhost" appBase="webapps" unpackWARs="true" autoDeploy="true">
                <Valve className="org.apache.catalina.valves.AccessLogValve" directory="logs" />
            </Host>
        </Engine>
    </Service>
</Server>





## tomcat的目录

tomcat-home
    |_bin
    |_conf
        |_Catalina
        |_server.xml
        |_web.xml
        |_context.xml
    |_lib
    |_logs
    |_temp
    |_webapps
    |_work

### server.xml
是关于tomcat的主要配置入口
### web.xml
This document defines default values for all web applications.
As each application is deployed, this file is processed, followed by the "/WEB-INF/web.xml" deployment descriptor from your own applications.
比如:
org.apache.catalina.servlets.DefaultServlet
org.apache.jasper.servlet.JspServlet
session-config
mime-mapping
welcome-file-list

#### org.apache.catalina.servlets.DefaultServlet
The default servlet for all web applications, that serves static resources.  It processes all requests that are not mapped to other servlets with servlet mappings (defined either here or in your own web.xml file).

<!-- The mapping for the default servlet -->
<servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>

#### org.apache.jasper.servlet.JspServlet
The JSP page compiler and execution servlet, which is the mechanism used by Tomcat to support JSP pages.  Traditionally, this servlet is mapped to the URL pattern "*.jsp".

<!-- The mappings for the JSP servlet -->
<servlet-mapping>
    <servlet-name>jsp</servlet-name>
    <url-pattern>*.jsp</url-pattern>
    <url-pattern>*.jspx</url-pattern>
</servlet-mapping>	

#### logs

catalina相关的日志(应用加载/卸载)
catalina.2024-07-27.log

host日志(conf/server.xml中可以配置多个虚拟host)
localhost.2024-07-27.log

access日志
localhost_access_log.2024-07-27.txt



### 注意点
可以通过修改模块的dependencies,将tomcat/lib作为runtime的依赖,方便debug时stepping

