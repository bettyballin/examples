function is_executable_content($filename) {
    $content = file_get_contents($filename);
    $finfo = finfo_open(FILEINFO_MIME_TYPE);
    $mime_type = finfo_buffer($finfo, $content);
    finfo_close($finfo);

    return strpos($mime_type, 'application/x-dosexec') !== false ||
           strpos($mime_type, 'application/octet-stream') !== false;
}