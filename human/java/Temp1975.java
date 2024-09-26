bash
#!/bin/bash

# Set the path to GlassFish home directory
GLASSFISH_HOME=/path/to/glassfish

# Enable secure admin with custom aliases
$GLASSFISH_HOME/bin/asadmin enable-secure-admin --adminalias=myOwnAlias --instancealias myOwnAlias

# Restart the domain
$GLASSFISH_HOME/bin/asadmin restart-domain