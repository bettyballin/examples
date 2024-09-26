<?php
session_start();

function checkPermissions() {
    $userRole = $_SESSION['userRole'];
    switch ($userRole) {
        case 'merchant':
            $permissions = 1; // merchant permissions
            break;
        case 'buyer':
            $permissions = 2; // buyer permissions
            break;
        default:
            $permissions = 0; // invalid role
    }
    $_SESSION['userPermissions'] = $permissions;
}

// Example usage
$_SESSION['userRole'] = 'merchant';
checkPermissions();
echo $_SESSION['userPermissions']; // Output: 1
?>