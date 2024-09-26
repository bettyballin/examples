<?php
require_once 'DOMPurify.php';

$content = '<b>Hello</b> <i>World</i> <u>Example</u> <a href="https://example.com">Link</a> <script>alert("XSS")</script>';

$content = DOMPurify::sanitize($content, [
    'allowed_tags' => ['b', 'i', 'u', 'a'],
    'allowed_attributes' => ['a' => ['href']]
]);

print $content;
?>