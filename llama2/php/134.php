function my_include($file) {
    $allowed_files = array('allowed_file1.php', 'allowed_file2.php'); // define allowed files
    // Check if $file is allowed
    if (in_array($file, $allowed_files)) {
        return include $file;
    } else {
        // If not allowed return false
        return false;
    }
}

// Register the custom include function
set_include_path(get_include_path());
spl_autoload_register(function($file) {
    my_include($file);
});