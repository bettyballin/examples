<?php
function escape_val($arr, $key, $default = ''){
    return isset($arr[$key]) ? htmlspecialchars($arr[$key]) : htmlspecialchars($default);
}

$_POST = array(
    'username' => 'test_user',
    'key' => 'some_value'
);

$username = escape_val($_POST, 'username');
$some_other = escape_val($_POST,'key','default_value');

print($username . "\n");
print($some_other . "\n");
?>