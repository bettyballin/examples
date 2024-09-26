<?php

// Define the server secret
define('SERVER_SECRET', 'your_secret_key_here');

// Check signature
$unix_ts_req = $_GET['t'];
$sig = hash_hmac('sha256', $unix_ts_req, SERVER_SECRET);

// Check if signature match
if($sig === $_GET['sig'])
{
    $gap = time() - (int)$unix_ts_req;
    if($gap < 3600)
    {
        echo "Valid";
    }
    else
    {
        echo "Expired";
    }
}
else
{
    echo "URL Tampered";
}

?>