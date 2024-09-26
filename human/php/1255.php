<?php

return [
    'plugin' => [
        'tx_yourExtKey' => [
            'persistence' => [
                'classes' => [
                    'YourVendor\\YourExtKey\\Domain\\Model\\BackendUser' => [
                        'mapping' => [
                            'tableName' => 'be_users',
                        ],
                    ],
                ],
            ],
        ],
    ],
];