<?php

$securityConfig = array(
    'security' => array(
        'providers' => '%security_providers%',
        'firewalls' => array(
            'dev' => array(
                // [...]
            ),
            'user_manager' => '%security_firewalls_user_management%',
        ),
    ),
);

return $securityConfig;