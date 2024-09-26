
$sanitized_post = array();
foreach($_POST as $name => $value) {
    // Remove specific characters
    $value = preg_replace( "/[<>#$%]/", "", $value);
    
    // Replace multiple spaces with a single space
    $value = preg_replace('/\s\s+/', ' ', $value);

    // Store the sanitized value in a new array
    $sanitized_post[$name] = $value;
}

// Now, when you want to use a sanitized value, you can do the following:
$FirstName = mysqli_real_escape_string($link, $sanitized_post['FirstName']);

