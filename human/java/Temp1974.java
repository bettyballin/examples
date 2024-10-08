sh
#!/bin/bash

# Set the GLASSFISH_HOME variable
GLASSFISH_HOME=/path/to/glassfish

# Restart your domain without secure-admin
$GLASSFISH_HOME/bin/asadmin disable-secure-admin

# Go to your domain config folder to remove the certificates:
cd $GLASSFISH_HOME/domains/domain1/config/
keytool -delete -alias s1as -keystore keystore.jks -storepass changeit
keytool -delete -alias glassfish-instance -keystore keystore.jks -storepass changeit
keytool -delete -alias glassfish-instance -keystore cacerts.jks -storepass changeit
keytool -delete -alias s1as -keystore cacerts.jks -storepass changeit