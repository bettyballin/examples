<?php

function getUserByUsername($username) {
    // This is a placeholder function, you would typically use a database query to retrieve the user
    $users = array(
        'test' => array('salts' => 'specific_salt:global_salt')
    );
    return $users[$username];
}

$username = 'test';
$user = getUserByUsername($username);

if ($user) {
    // Get salts
    list($specific_salt, $global_salt) = explode(':', $user['salts']);
    print_r($specific_salt);
    print_r($global_salt);
}