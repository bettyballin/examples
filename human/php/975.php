<?php
$value = 'Test "value" with <script>alert("XSS")</script>';
echo htmlspecialchars(trim($value), ENT_QUOTES, "UTF-8");
?>