<?php

$SECRET = "idkfaiddqd";
$data = [
  "citizenNo" => "9990601821487",
  "birthDate" => "2520-02-24",
];

$transform_body = str_replace([' ', '\''], ['' , '"'], json_encode($data));
$aaa = hash_hmac('sha256', $transform_body, $SECRET);

echo $aaa;

?>