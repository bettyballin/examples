<?php

require 'vendor/autoload.php';

use GuzzleHttp\Client;

$zapUrl = 'http://localhost:8080';
$apiKey = 'your-api-key'; // replace with your actual API key

// Start ZAP daemon if it's not running already.
shell_exec("java -jar zap.jar -daemon -config api.key=$apiKey > /dev/null 2>&1 &");

sleep(5); // Wait for Zap to start

// Set up the API client
$zapClient = new Client([
    'base_uri' => $zapUrl
]);

// Create a context and user in ZAP.
$response = $zapClient->post('/JSON/context/action/newContext/', [
    'json' => ['contextName' => 'My Context', 'apiKey' => $apiKey]
]);
$contextId = json_decode($response->getBody(), true)['contextId'];

$response = $zapClient->post("/JSON/users/action/newUser/?contextId=$contextId&name=User1", [
    'json' => []
]);

// Add authentication credentials for the user.
$response = $zapClient->post('/JSON/authentication/action/setAuthenticationMethod/', [
    'json' => [
        'contextId' => $contextId,
        'userId' => 0,
        'authMethodName' => 'formBasedAuthentication',
        'authMethodConfigParams' => '{"loginUrl":"http://example.com/login","usernameParameter":"user","passwordParameter":"pass"}'
    ]
]);

// Start the spider.
$response = $zapClient->post('/JSON/spider/action/scan/', [
    'json' => ['url' => 'http://example.com', 'contextId' => $contextId, 'userId' => 0]
]);

// Wait for Spider to complete
sleep(60);

// Perform an active scan.
$response = $zapClient->post('/JSON/ascan/action/scan/', [
    'json' => ['url' => 'http://example.com', 'contextId' => $contextId, 'userId' => 0]
]);

?>