<?php

$providers = [
    # ... your other providers up here.
    'all_users' => [
        'chain' => [
            'providers' => ['customer', 'dealer']
        ]
    ]
];

print_r($providers);

?>