<?php
// This code is not directly executable in PHP as it appears to be JavaScript.
// However, we can achieve similar functionality using PHP's header function.

if ($_SERVER['HTTP_REFERER'] != $_SERVER['REQUEST_URI']) {
    header('Location: '.$_SERVER['REQUEST_URI']);
    exit;
}
?>