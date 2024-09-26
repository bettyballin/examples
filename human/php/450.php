<?php
$ipAllowed = array('192.192.192', '172.172.172');

$allowed = false;
foreach($ipAllowed as $ip) {
     if (strpos($_SERVER['REMOTE_ADDR'], $ip) !== false) {
         $allowed = true;
         break;
     }
}
if (!$allowed) {
    header('HTTP/1.0 403 Forbidden');
    die('You are not allowed to access this file.');     
}
?>