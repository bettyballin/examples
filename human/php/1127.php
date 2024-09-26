<?php

// get users IP address
$ip = $_SERVER['REMOTE_ADDR'];

// find out if user has already been blocked
$getblockedq = 'SELECT ip FROM blocked_logins WHERE ip = :ip';
$getblocked = $muc->prepare($getblockedq);
$getblocked->execute(array(':ip' => $ip));
$total = $getblocked->fetchColumn();

if ($total > 0) {
    // user is blocked, do not proceed
    exit('You are blocked!');
}

// find number of failed logins within past 15 mins
$getfailedq = 'SELECT Count(*) AS failed FROM failed_logins WHERE ip = :ip AND attempted > Date_sub(Now(), INTERVAL 15 minute)';
$getfailed = $muc->prepare($getfailedq);
$getfailed->execute(array(':ip' => $ip));
$total = $getfailed->fetchColumn();

if ($total <= 2) {
    // looks good, attempt to login
    echo 'Login attempt allowed!';
} elseif ($total <= 10) {
    // you must wait x seconds...
    $waitTime = 30; // adjust wait time in seconds
    echo "You must wait $waitTime seconds before attempting to login again.";
} elseif ($total <= 1000) {
    // display captcha
    echo 'Captcha required!';
} else {
    // block user
    $blockq = 'INSERT INTO blocked_logins (ip) VALUES (:ip)';
    $block = $muc->prepare($blockq);
    $block->execute(array(':ip' => $ip));
    echo 'You have been blocked!';
}