<?php
$user_input = '<p><strong>Hello</strong> World!</p>';
$safe_html = strip_tags($user_input, '<p><strong>');
echo $safe_html; // Output: <p><strong>Hello</strong></p>
?>