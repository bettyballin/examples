
if (isset($_SERVER['HTTP_HOST']) && $_SERVER['HTTP_HOST'] === 'contenteditor.net') {
    // Allow access
} else if (!isset($_SESSION['your_session_variable'])) {
    // Disallow access because the session variable is not set
    // Redirect or show an error
}

