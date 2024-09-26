
<?php
session_start();

// Array to hold the codes associated with your images
$captcha_codes = [
    'code_01' => '123456', // Replace with the actual number in your GIF
    'code_02' => '234567', // Replace with the actual number in your GIF
    // ... Add all your codes here
];

// Select a random code key
$random_key = array_rand($captcha_codes);
$_SESSION['captcha'] = $captcha_codes[$random_key]; // Store the correct answer

// Display the image in the form
echo '<img src="captcha_images/' . $random_key . '.gif" alt
