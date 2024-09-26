<?php

class ApiClient {
    private $apiEndpoint;
    private $token;

    public function __construct($apiEndpoint) {
        $this->apiEndpoint = $apiEndpoint;
    }

    public function authenticate($username, $password) {
        $ch = curl_init($this->apiEndpoint . '/login');
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_POST, true);
        curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode(['username' => $username, 'password' => $password]));
        curl_setopt($ch, CURLOPT_HTTPHEADER, ['Content-Type: application/json']);
        $response = curl_exec($ch);
        curl_close($ch);
        $data = json_decode($response, true);
        if (isset($data['token'])) {
            $this->token = $data['token'];
        } else {
            throw new Exception('Authentication failed');
        }
    }

    public function makeRequest($method, $endpoint, $data = []) {
        $ch = curl_init($this->apiEndpoint . $endpoint);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, $method);
        if (!empty($data)) {
            curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($data));
            curl_setopt($ch, CURLOPT_HTTPHEADER, ['Content-Type: application/json']);
        }
        if ($this->token) {
            curl_setopt($ch, CURLOPT_HTTPHEADER, ['Authorization: Bearer ' . $this->token]);
        }
        $response = curl_exec($ch);
        curl_close($ch);
        return json_decode($response, true);
    }
}

$client = new ApiClient('https://api.example.com');
$client->authenticate('username', 'password');
$result = $client->makeRequest('GET', '/data');
print_r($result);

?>