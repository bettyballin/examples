<?php
function validateUser($userid, $userType) {
    session_start();
    session_regenerate_id ();
    $_SESSION['valid'] = 1;
    $_SESSION['uID'] = $userid;
    $_SESSION['type'] = $userType; // 1 for buyer - 2 for merchant
}

// example usage
$userid = 'some_user_id';
$userType = 1; // or 2
validateUser($userid, $userType);
?>