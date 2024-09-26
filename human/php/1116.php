<?php

if ($_SERVER['REMOTE_ADDR'] != '127.0.0.1') {
    function show_error($message) {
        echo $message;
        exit;
    }
    show_error("Daily CRON tasks can only be run from the command line on the live server.");
}

?>