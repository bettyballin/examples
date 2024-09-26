<?php
session_start();
session_regenerate_id(true); // avoid trivial session fixation
$_SESSION['valid'] = true;
$_SESSION['user_id'] = 123; // identify the user
// whatever else you want to add in your session
header('Location: /index.php'); // redirect the user after signing in
exit;
?>