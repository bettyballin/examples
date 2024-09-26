<?php
// make sure user is logged in
if (!$user->loggedIn()) {
    header('Location: login.php');
    exit;
}
?>