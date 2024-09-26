<?php
$config = parse_ini_file('/home/some_user/config/mysql.ini');

// Or use json
//$config = json_decode(file_get_contents('/home/some_user/config/mysql.json'), true);

// Or include php config file
//require_once '/home/some_user/config/mysql_config.php';

print_r($config);
?>