
<?php
$data = ['user_id' => '5', 'user_type' => '2', 'ssn' => '1234567890', 'first_name' => 'John', 'last_name' => 'Doe'];
$serializedData = serialize($data);
$encryptedData = openssl_encrypt($serializedData, 'aes-256-cbc', $encryptionKey, 0, $iv);
$encodedData = urlencode(base64_encode($encryptedData));
header('Location
