<?php
foreach ($_POST as $key => &$value) {
    // Sanitize strings for HTML output
    $value = htmlspecialchars($value, ENT_QUOTES | ENT_SUBSTITUTE, 'UTF-8');

    // Optionally remove any tags from the input (e.g to prevent XSS)
    //$value = strip_tags($value);
}
?>