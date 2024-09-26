<?php
session_start();
if (!isset($_SESSION['valid'])) {
    die("Invalid session");
}
// do stuff with $_SESSION['user_id']
?>