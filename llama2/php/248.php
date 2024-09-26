$allowed_tags = array('div', 'span', 'p');
$allowed_attributes = array('class' => true, 'style' => true);

$input = $_POST['custom_exclude_pattern'];

// Validate input with regular expression
if (!preg_match('/^<(\\w+)[^>]*?\\s+(?:class|style)\\s*=\\s*([\"'])([a-zA-Z0-9\\s]+)\\2$/', $input, $matches)) {
    // Invalid input
    echo "Invalid input";
    exit;
}

// Sanitize input
$tag = strtolower($matches[1]);
$attribute = strtolower($matches[2]);
$value = $matches[3];

if (!in_array($tag, $allowed_tags)) {
    // Tag is not allowed
    echo "Tag is not allowed";
    exit;
}

if (!isset($allowed_attributes[$attribute])) {
    // Attribute is not allowed
    echo "Attribute is not allowed";
    exit;
}

// Sanitized input
$sanitized_input = "<$tag $attribute=\"$value\">";

// Print sanitized input
echo $sanitized_input;