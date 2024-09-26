
<?php
session_start();

// Check if we should skip the login check
if (empty($skip_login_check)) {
    if (isset($_SESSION['username'])) {
        echo "Welcome " . $_SESSION['username'] . " HOmeSignout";
    }
