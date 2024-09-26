<?php

$config = [
    'paths' => [
        'stack' => storage_path('logs/stack.log'),
    ],
    'names' => [
        'stack' => 'Stack',
    ],
];

function storage_path($path) {
    return __DIR__ . DIRECTORY_SEPARATOR . $path;
}

print_r($config);

?>