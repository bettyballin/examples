<?php
// On submit create a new session and set download access flag
session_start();
$_SESSION['download_access'] = true;
?>