<?php
$output = "Hello, World!";
echo htmlspecialchars($output, ENT_QUOTES | ENT_HTML5, 'UTF-8');
?>