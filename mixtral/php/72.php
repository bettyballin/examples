<?php
$conType = trim($this->params->get('conType'));

if ($conType === '1') {
    $containerClass = '-fluid';
} else {
    $containerClass = '';
}

// Use the class in HTML
echo '<div class="container' . htmlspecialchars($containerClass, ENT_QUOTES) . '">...</div>';
?>