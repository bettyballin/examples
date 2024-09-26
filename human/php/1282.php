<?php
if (!isset($_GET['key']) || ($_GET['key'] !== 'password123')) {
    die('You shall not pass!');
} else {
    echo "Welcome, authenticated user!";
    // do your magic
}
?>