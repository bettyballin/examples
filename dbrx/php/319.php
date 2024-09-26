<?php
$username = "test";
if (preg_match('/^[a-zA-Z0-9]+$/', $username)) {
    echo "Valid username!";
} else {
    echo "Invalid username!";
}
?>