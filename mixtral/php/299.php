<?php

$data = array(
    'name' => 'John Doe',
    'email' => 'john@example.com',
    'description' => '<script>alert("XSS")</script>',
);

foreach($data as $key => &$value){
    if(is_string($value)){
        // Sanitizing string
        $value = htmlspecialchars(strip_tags($value));
    }
}

print_r($data);

?>