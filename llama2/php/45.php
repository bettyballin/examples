<?php

$permissionMatrix = [
    'admin' => ['create', 'read', 'update', 'delete'],
    'moderator' => ['read', 'update', 'delete'],
    'user' => ['read']
];

function hasPermission($role, $action) {
    global $permissionMatrix;
    return in_array($action, $permissionMatrix[$role]);
}

// Test the function
echo var_export(hasPermission('admin', 'create'), true) . "\n"; // Expected output: true
echo var_export(hasPermission('moderator', 'create'), true) . "\n"; // Expected output: false
echo var_export(hasPermission('user', 'read'), true) . "\n"; // Expected output: true

?>