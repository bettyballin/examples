<?php
include "mysessionhandler.php";
$session = new linusLogin_Session();
session_set_save_handler(
    array($session, 'open'),
    array($session, 'close'),
    array($session, 'read'),
    array($session, 'write'),
    array($session, 'destroy'),
    array($session, 'gc')
);
session_name('llSSID');
session_start();
// The rest of your site goes here
?>