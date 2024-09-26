<?php
session_start();
$_SESSION['redir_after_auth'] = $_SERVER['PHP_SELF'];
header('Location: http://domain.com/login?sid='.session_id());
exit;
?>