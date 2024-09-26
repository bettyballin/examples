<?php
require_once __DIR__ . '/facebook-php-sdk/src/Facebook.php';

// Initialize Facebook PHP SDK
$fb = new Facebook(array(
    'appId' => 'YOUR_APP_ID',
    'secret' => 'YOUR_APP_SECRET',
));

// Obtain Access Token
$accessToken = $fb->getAccessToken();

// Query Graph API to check session status
$response = $fb->get('me?fields=id,name,email');