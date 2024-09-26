<?php
$user_input = "This is a test sentence with < and > symbols.";
$sanitized_input = htmlspecialchars($user_input);
echo $sanitized_input;
// Output: This is a test sentence with &lt; and &gt; symbols.
?>