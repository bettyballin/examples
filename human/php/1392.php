<?php
$json = '{"citizenNo":"9990601821487","birthDate":"2520-02-24"}';
$data = json_decode($json, true);
print_r($data);
?>