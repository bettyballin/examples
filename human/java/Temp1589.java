sh
/usr/local/java/jdk6/bin/java -server \
-Duser.timezone=America/Sao_Paulo -XX:MaxPermSize=128m -Xms30m -Xmx1024m \
-Djava.endorsed.dirs=/var/tomcat/7.0/endorsed \
-classpath /var/tomcat/7.0/bin/bootstrap.jar \
-Djava.security.manager \
-Djava.security.policy=/var/tomcat/7.0/conf/catalina.policy \
-Dcatalina.base=/var/tomcat/7.0 -Dcatalina.home=/var/tomcat/7.0 \
-Djava.security.debug=all \
-Djava.io.tmpdir=tmpdir org.apache.catalina.startup.Bootstrap \
-config dir/to/xml.conf start