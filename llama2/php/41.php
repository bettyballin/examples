<?php
class Sanitize {
    public static function getString($input) {
        return filter_var($input, FILTER_SANITIZE_STRING);
    }
}

$user_input = 'Hello, World!';
$sanitized_data = Sanitize::getString($user_input);
print($sanitized_data);
?>