<?php
// Start basic user session
session_name('basic_user');
session_start();

// ... perform actions related to regular users ...
$_SESSION['username'] = 'john_doe';
$_SESSION['role'] = 'customer';

// Print session variables for basic user
echo "Basic User Session Variables:\n";
print_r($_SESSION);

// Close the current session and start an admin session
session_write_close();
session_name('admin_session');
session_start();

// Perform administrative tasks
$_SESSION['admin_username'] = 'admin_user';
$_SESSION['admin_role'] = 'administrator';

// Print session variables for admin
echo "\nAdmin Session Variables:\n";
print_r($_SESSION);

?>