
<?php
session_start();

// Generate CAPTCHA code
$code = rand(1000, 9999);
$_SESSION["captcha"] = $code;

// Create an image
$width = 80;
$height = 40;
$image = imagecreate($width, $height);

// Colors
$background_color = imagecolorallocate($image, 255, 255, 255);
$text_color = imagecolorallocate($image, 0, 0, 0);

// Draw the string on the image
imagestring($image, 5, 10, 10, $code, $text_color);

// Set the content-type
header("Content-Type: image/png
