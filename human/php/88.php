<?php

// envvars - default environment variables for apache2ctl

// Since there is no sane way to get the parsed apache2 config in scripts, some
// settings are defined via environment variables and then used in apache2ctl,
// /etc/init.d/apache2, /etc/logrotate.d/apache2, etc.
putenv("APACHE_RUN_USER=www-data");
putenv("APACHE_RUN_GROUP=www-data");
putenv("APACHE_PID_FILE=/var/run/apache2.pid");

## The locale used by some modules like mod_dav
putenv("LANG=C");
## Uncomment the following line to use the system default locale instead:
// putenv("/etc/default/locale");

putenv("LANG");

umask(022);

?>