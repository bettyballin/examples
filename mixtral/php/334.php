<?php
$allowed_files = ['file1', 'file2'];

if (isset($_GET['page']) && in_array($_GET['page'], $allowed_files)) {
    include('subdir/' . $_GET['page'] . '.html');
} else {
    // Handle invalid parameter
    echo "Invalid page";
}
?>