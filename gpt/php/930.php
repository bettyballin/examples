
<?php
session_start();
require_once 'DBconfig.php';

if (!isset($_SESSION['user_session'])) {
    header("HTTP/1.0 403 Forbidden");
    die('You are not authorized to access this page.');
}

// Fetch the file ID or path from the
