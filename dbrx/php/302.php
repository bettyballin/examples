<?php

function sanitize_data(&$data)
{
   $data = htmlspecialchars(trim(stripslashes(strip_tags($data))), ENT_QUOTES, 'UTF-8');
}

function validate_key_name(string $name): void
{
    if (!preg_match('/^[a-zA-Z0-9_]+$/', $name)) {
        throw new InvalidArgumentException('Invalid key name: '.$name);
    }
}

$json_string = $_POST['json_data'] ?? ''; // assuming you're getting this from POST data

$decoded_json = json_decode($json_string);

if (!is_object($decoded_json)) {
    echo 'Invalid JSON input';
    exit;
}

foreach ($decoded_json as $key => &$value) {
    if (is_array($value)) {  // handle arrays
        foreach ($value as &$sub_value) {
            sanitize_data($sub_value);
        }
     } else {
         sanitize_data($value); 
     }

     validate_key_name($key);

}

print_r($decoded_json);

?>