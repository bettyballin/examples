<?php

$app = [];

$app['security.firewalls'] = [
    'secured' => [
        'form' => [
            'login_path' => '/login',
            'check_path' => '/secured/login_check',
            'always_use_default_target_path' => false,
            'use_referer' => true
        ]
    ]
];

print_r($app);

?>