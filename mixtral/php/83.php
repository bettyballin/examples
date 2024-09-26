<?php
session_start();

if (!isset($_SESSION['user_ip']) || $_SESSION['user_ip'] != md5($_SERVER['REMOTE_ADDR'])
    || !isset($_SESSION['user_agent']) || $_SESSION['user_agent'] != substr(md5($_SERVER['HTTP_USER_AGENT']), 0, 16)) {

   // Session does not match the user's IP or User Agent.
   echo "Session does not match the user's IP or User Agent.";
} else {
   echo "Session matches the user's IP and User Agent.";
}
?>