
$directory = new RecursiveDirectoryIterator('path/to/your/php/files');
$iterator = new RecursiveIteratorIterator($directory);

foreach ($iterator as $file) {
    if (pathinfo($file, PATHINFO_EXTENSION) == 'php') {
        $content = file_get_contents($file);
        
        // Use a regex to find all $_POST[...] occurrences
        preg_match_all('/\$_POST\[\s*\'([^\']+)\'\s
