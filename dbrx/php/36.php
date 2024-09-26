<?php

// Set post fields for first request (to local server)
$post_fields = array(
    'field1' => $_POST['field1'],
    // Add other form fields here...
);

$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, "http://your-local-server.com/script.php");
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($post_fields));
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1); 

$response = curl_exec($ch);
curl_close($ch);

// Set post fields for second request (to remote server)
$post_fields['private_key'] = 'your-private-key';

$remote_ch = curl_init();
curl_setopt($remote_ch, CURLOPT_URL, "http://distant-server.com/script.php");
curl_setopt($remote_ch, CURLOPT_POST, true);
curl_setopt($remote_ch, CURLOPT_POSTFIELDS, http_build_query($post_fields));
curl_setopt($remote_ch, CURLOPT_RETURNTRANSFER, 1); 

$remote_response = curl_exec($remote_ch);
curl_close($remote_ch);

// Handle responses as needed...
print_r($response);
print_r($remote_response);

?>