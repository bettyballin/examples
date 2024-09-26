<?php

$access_control = [
    [
        'path' => '^/login$',
        'role' => 'IS_AUTHENTICATED_ANONYMOUSLY'
    ],
    [
        'path' => '^/register',
        'role' => 'IS_AUTHENTICATED_ANONYMOUSLY'
    ],
    [
        'path' => '^/resetting',
        'role' => 'IS_AUTHENTICATED_ANONYMOUSLY'
    ],
    [
        'path' => '^/admin/',
        'role' => 'ROLE_ADMIN'
    ],
    [
        'path' => '^/*',
        'role' => 'ROLE_USER'
    ],
    [
        'path' => '^/',
        'role' => 'IS_AUTHENTICATED_ANONYMOUSLY'
    ]
];

print_r($access_control);