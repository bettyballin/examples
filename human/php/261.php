<?php

header('Content-type: text/html; charset=utf-8');
error_reporting(E_ALL | E_STRICT);
ini_set('display_errors', 1);

$config = array(
    'host' => '127.0.0.1', 
    'user' => 'my_user', 
    'pass' => 'my_pass', 
    'db' => 'my_database'
);

$connection = mysql_connect($config['host'], $config['user'], $config['pass']);

if (!$connection) {
    trigger_error('Unable to connect to database: ' . mysql_error(), E_USER_ERROR);
}

if (!mysql_select_db($config['db'])) {
    trigger_error('Unable to select db: ' . mysql_error(), E_USER_ERROR);
}

if (!mysql_set_charset('utf8')) {
    trigger_error('Unable to set charset for db connection: ' . mysql_error(), E_USER_ERROR);
}

if (isset($_POST['id']) && isset($_POST['name'])) {
    $result = mysql_query(
        'UPDATE tablename SET name = "' 
        . mysql_real_escape_string($_POST['name']) 
        . '" WHERE id = "' 
        . mysql_real_escape_string($_POST['id']) . '"'
    );

    if ($result) {
        echo htmlentities($_POST['name'], ENT_COMPAT, 'utf-8') . ' updated.';
    } else {
        trigger_error('Unable to update db: ' . mysql_error(), E_USER_ERROR);
    }
} else {
    echo 'Please provide id and name.';
}

mysql_close($connection);

?>