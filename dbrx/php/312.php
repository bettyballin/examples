<?php
function set_directory_nonexecutable($directory) {
    $files = new RecursiveIteratorIterator(
        new RecursiveDirectoryIterator($directory, FilesystemIterator::SKIP_DOTS),
        RecursiveIteratorIterator::CHILD_FIRST
    );

    foreach ($files as $fileinfo) {
        chmod($fileinfo->getRealPath(), 0644);
    }
}

// Example usage
set_directory_nonexecutable('/path/to/directory');