<?php

function secureOutput($data, $context = '') {
    if (is_array($data)) {
        return array_map('secureOutput', $data, array_fill(0, count($data), $context));
    }

    // Escape for HTML contexts
    $escapedData = htmlspecialchars($data, ENT_QUOTES | ENT_SUBSTITUTE, 'UTF-8');

    // Check if the output will be used within a JavaScript context
    if (strpos($context, '<script') !== false) {
        return json_encode($escapedData);
    }

    return $escapedData;
}

// Test the function
$data = array('Hello', 'World', '<script>alert("XSS")</script>');
$context = '<script>var data = ';
print_r(secureOutput($data, $context));

?>