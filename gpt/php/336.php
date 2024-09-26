
function isFileInDirectory($file, $directory) {
    // Ensure there is no trailing slash in the directory path
    $directory = rtrim($directory, '/');

    // Resolve the absolute path of the file
    $realFilePath = realpath($file);

    // If realpath returns false, the file does not exist or is not accessible
    if ($realFilePath === false) {
        return false;
    }

    // Ensure that the file is within the directory tree
    $realDirectoryPath = realpath($directory);
    $isWithinDirectory = strpos($realFilePath, $realDirectoryPath) === 0;

    // Check if the file is within the directory tree and the file exists
    return $isWithinDirectory && file_exists($realFilePath);
}

// Usage
$
