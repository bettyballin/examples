function safeResolvePath($path)
{
    $segments = explode('/', trim($path, '/'));

    foreach ($segments as $i => &$segment) {
        if ('..' === $segment || '.' === $segment) {
            unset($segments[$i]);
        } else {
            break; // Stop processing segments when we encounter a non-relative one.
        }
    }

    return implode('/', array_filter($segments));
}

// Test the function
$path = "/var/www/../html/./test.php";
echo safeResolvePath($path);