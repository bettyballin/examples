<?php
putenv('MYSQL_USER=myuser');
putenv('MYSQL_PASSWORD=mypassword');

// Test the environment variables
echo getenv('MYSQL_USER') . "\n";
echo getenv('MYSQL_PASSWORD') . "\n";
?>