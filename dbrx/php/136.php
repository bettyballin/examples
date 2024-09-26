<?php
session_start();

if (isset($_SESSION['LAST_ACTIVITY']) && (time() - $_SESSION['LAST_ACTIVITY'] > 1800)) {
    // last request was more than 30 minutes ago
    session_regenerate_id(true); 
}
$_SESSION['LAST_ACTIVITY'] = time();
?>