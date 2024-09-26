<?php
$permissionMatrix = [
    'admin' => ['edit', 'readonly'],
    'moderator' => ['readonly'],
    'user' => []
];

print_r($permissionMatrix);
?>