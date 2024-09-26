<?php

return [
    'security' => [
        'encoders' => [
            'FOS\UserBundle\Model\UserInterface' => [
                'id' => 'sdz_user.custom_encoder',
            ],
        ],
    ],
];