<?php
mysql_connect('localhost', getenv('PHP_MYSQL_USER'), getenv('PHP_MYSQL_PWD'));
putenv('PHP_MYSQL_USER=');
putenv('PHP_MYSQL_PWD=');
?>