<?php
session_start();

if (!isset($_SESSION['hash'])) {
    $_SESSION['hash'] = md5(!empty($_SERVER['HTTP_USER_AGENT']) ? $_SERVER['HTTP_USER_AGENT'] : 'no ua');
} elseif ($_SESSION['hash'] != md5(!empty($_SERVER['HTTP_USER_AGENT']) ? $_SERVER['HTTP_USER_AGENT'] : 'no ua')) {
    session_regenerate_id(true);
    $_SESSION = array();
    $_SESSION['hash'] = md5(!empty($_SERVER['HTTP_USER_AGENT']) ? $_SERVER['HTTP_USER_AGENT'] : 'no ua');
}
?>