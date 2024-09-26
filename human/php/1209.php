<?php
define('SERVER_SECRET', 'your_secret_key_here');

// create this link for use in 1 hour
$unix_ts = time();

//convert to string
$unix_ts = (string) $unix_ts;

//compute signature
$sig = hash_hmac('sha256', $unix_ts, SERVER_SECRET);

$create_link = 'https://.....?t='.$unix_ts.'&sig='.$sig;

echo $create_link;
?>