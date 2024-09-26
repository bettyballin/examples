<?php

$sanitize_string = array(
  'filter' => FILTER_SANITIZE_STRING,
  'flags'  => FILTER_REQUIRE_SCALAR | FILTER_FLAG_STRIP_LOW | FILTER_FLAG_STRIP_HIGH,
);

$user_input = filter_input_array(
  INPUT_POST,
  array(
    'hostname' => $sanitize_string, 
    'username' => $sanitize_string,
    'password' => FILTER_UNSAFE_RAW, 
    'port'     => array(
     'filter' => FILTER_VALIDATE_INT,
     'flags'  => FILTER_REQUIRE_SCALAR,
     'options' => array('min_range' => 666, 'max_range' => 3600),
   ),
  ),
  true
);

foreach ($user_input as $input) {
  if (!$input) { 
    trigger_error("No no my dear!", E_USER_ERROR);
  }
}

list($host, $user, $pass, $port) = $user_input;
$mysqli = new mysqli($host, $user, $pass, '', $port);

?>