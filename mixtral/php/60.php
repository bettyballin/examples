<?php

$allowed_tags = '<b><i>';
$input = '<b>Hello</b> <script>alert("XSS")</script> <i>World</i>';

// Validate input on server-side

// Encode all HTML entities
$encodedInput = htmlspecialchars($input, ENT_QUOTES);

// Strip disallowed tags
$sanitizedInput = strip_tags($encodedInput, $allowed_tags);

echo $sanitizedInput;

?>