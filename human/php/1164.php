<?php
$load_balancer = '10.20.30.40';
$ip = $_SERVER['REMOTE_ADDR'];
if (isset($_SERVER['X_FORWARDED_FOR']) && $ip == $load_balancer) {
    $ip = $_SERVER['X_FORWARDED_FOR'];
}