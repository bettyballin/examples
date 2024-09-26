<?php

// Your SMS code here...

// Send SMS using Nexmo API
require_once 'vendor/autoload.php';
use Nexmo\Client;

$basic  = new \Nexmo\Client\Credentials\Basic('YOUR_API_KEY', 'YOUR_API_SECRET');
$client = new \Nexmo\Client($basic);

$response = $client->sms()->send(
    new \Nexmo\Sms\Message\OutboundMessage(
        new \Nexmo\Sms\Message\From('YOUR_FROM_NUMBER'),
        new \Nexmo\Sms\Message\To('YOUR_TO_NUMBER'),
        'Hello from Nexmo!'
    )
);

$response = $response->getResponseData();

if($response['messages'][0]['status'] == '0'){
    echo "SMS sent successfully";
} else {
    echo "Error sending SMS";
}

header('Location: http://www.example.com/');
exit;

?>