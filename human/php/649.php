<?php
$untrustedData = '<script>alert("XSS")</script>';

echo '<p>' . strip_tags($untrustedData) . '</p>';

echo '<a name="' . htmlspecialchars($untrustedData) . '">trusted data</a>';
?>