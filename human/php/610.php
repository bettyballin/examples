<?php

function escape_data($data, $context) {
    switch ($context) {
        case 'html':
            return htmlspecialchars($data, ENT_QUOTES | ENT_HTML5, 'UTF-8');
        case 'attribute':
            return htmlspecialchars($data, ENT_QUOTES | ENT_HTML5, 'UTF-8');
        case 'javascript':
            return json_encode($data);
        default:
            throw new Exception('Invalid context');
    }
}

$data = "<script>alert('XSS')</script>";
$context = "html";

echo escape_data($data, $context);

?>