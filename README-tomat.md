# 关于tomcat的知识

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


### 

