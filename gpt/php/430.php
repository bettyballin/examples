
spl_autoload_register(function ($class) {
    $file = 'path/to/' . $class . '.php';
    // Add your logic to check if the file should be included.
    if (
