<?php

$accessControl = [
    ['path' => '^/$', 'role' => 'IS_AUTHENTICATED_ANONYMOUSLY'],
    ['path' => '^/login$', 'role' => 'IS_AUTHENTICATED_ANONYMOUSLY'],
    ['path' => '^/register', 'role' => 'IS_AUTHENTICATED_ANONYMOUSLY'],
    ['path' => '^/resetting', 'role' => 'IS_AUTHENTICATED_ANONYMOUSLY'],
    ['path' => '^/admin/', 'role' => 'ROLE_ADMIN'],
    ['path' => '^/*', 'role' => 'ROLE_USER'],
];

foreach ($accessControl as $rule) {
    echo "Path: " . $rule['path'] . ", Role: " . $rule['role'] . "\n";
}