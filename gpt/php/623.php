
function sanitizeFilePath($baseDir, $userInput) {
    // Remove any null bytes
    $userInput = str_replace(chr(0), '', $userInput);

    // Remove ../, ./, or // to prevent directory traversal
    $userInput = str_replace(['../', './', '//'], '', $userInput);

    // Optional: Remove all
