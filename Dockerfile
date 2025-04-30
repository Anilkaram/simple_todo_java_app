FROM tomcat

COPY tomcat-users.xml /usr/local/tomcat/conf/

COPY . /usr/local/tomcat/

EXPOSE 8080





