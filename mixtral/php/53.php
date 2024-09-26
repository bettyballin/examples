<?php

$userEmail = 'your_email@example.com';
$userPassword = 'your_password';

$data = array(
    'email' => $userEmail,
    'password' => $userPassword
);

$options = array('http' =>
  array(
      'method'  => 'POST',
      'header'=> "Content-Type: application/json\r\n".
                 "Accept: application/json\r\n",
      'content' => json_encode($data)
   )
);

$context = stream_context_create($options);

// Send the request
$result = file_get_contents('https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=[API-KEY]', false, $context);

print($result);

?>