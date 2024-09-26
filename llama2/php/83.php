<?php
$allowedExtensions = array('jpg', 'jpeg', 'png');
$text = "https://example.com/image.jpg"; // example URL
$text = filter_var($text, FILTER_VALIDATE_URL, array(
    'options' => array(
        'AllowedExtensions' => $allowedExtensions
    )
));
print($text);
?>