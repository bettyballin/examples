<?php

use Doctrine\DBAL\Configuration;
use Doctrine\DBAL\DriverManager;

$config = new Configuration();

$connectionParams = array(
    'dbname' => 'your_database_name',
    'user' => 'your_database_user',
    'password' => 'your_database_password',
    'host' => 'your_host',
    'driver' => 'pdo_mysql',
    'server_version' => '10.1.36-MariaDB',
);

$conn = DriverManager::getConnection($connectionParams, $config);