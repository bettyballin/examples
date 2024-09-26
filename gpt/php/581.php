
$allowed_files = ['file1.txt', 'file2.txt', 'file3.txt'];

$filename = $_GET["filename"];

if (in_array($filename, $allowed_files)) {
    $content = file_get_contents("/path_to_files/" . $filename);
} else {
    // Handle error
}

