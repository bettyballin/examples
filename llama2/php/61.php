<?php
session_start();
$oldSessionId = session_id();
session_regenerate_id();
$newSessionId = session_id();
$_SESSION = array_merge($_SESSION, array($oldSessionId));
session_id($newSessionId);
print_r($_SESSION);
?>