<?php
$file = $_REQUEST['file'];
if ($user->hasAccessTo($file)) {
    readfile("/server_root/protected_root/$file");
} else {
    readfile('access-denied.html');
}
?>