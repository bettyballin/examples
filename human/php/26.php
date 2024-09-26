<?php

$values = array(
    'user_id' => 1,
    'foo' => 'bar'
);
$secret = 'MySecretSalt';

$plain = "";
foreach ($values as $key => $value) {
    $plain .= $key . '|' . $value . '|';
}
$plain .= $secret;
$hash = sha1($plain);

echo $hash;

?>