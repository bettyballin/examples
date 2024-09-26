
$base_dir = '/path/to/allowed/directory/';
$file = basename($_GET['file']); // Use basename to prevent directory traversal attacks.
$real_path = realpath($base_dir . $
