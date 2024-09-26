
$filename = $_GET["filename"];
$filename = basename($filename); // Removes any path info from the filename

$content = file_get_contents("/path_to_files/" . $filename);

