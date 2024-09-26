
function create_file($path, $filename, $content, $overwrite=false) {
    // Normalize directory separators and ensure path ends with a slash
    $path = rtrim(str_replace('\\', '/', $path), '/') . '/';
    
    // Check if the filename format is correct
    if (!preg_match('/^[a-zA-Z0-9_-]+\.[a-zA-Z0-9]+$/', $filename)) {
        return false; // Invalid file name
    }

    // Real path of the directory where the script is running
    $baseDir = realpath($_SERVER['DOCUMENT_ROOT']);

    // Real path of the target directory
    $realPath = realpath($baseDir . '/' . $path);

    // Check if the real path of the target directory starts with the base directory's real path
    if ($realPath === false || strncmp($realPath, $baseDir, strlen
