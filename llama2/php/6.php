<?php

class MimeTypeDetector {
    public function detect($ftpUrl) {
        $parts = explode('://', $ftpUrl);
        $host = $parts[1];
        $username = $parts[2];
        $password = isset($parts[3]) ? $parts[3] : null;

        // Fetch the file contents
        $conn = ftp_connect($host);
        ftp_login($conn, $username, $password);
        $file = explode('/', $ftpUrl);
        $file = end($file);
        $fp = fopen('php://temp', 'r+');
        ftp_fget($conn, $fp, $file, FTP_BINARY);
        rewind($fp);
        $fileContents = stream_get_contents($fp);
        fclose($fp);
        ftp_close($conn);

        // Detect mime-type using fileinfo
        $finfo = finfo_open(FILEINFO_MIME_TYPE);
        $mimeType = finfo_buffer($finfo, $fileContents);
        finfo_close($finfo);

        return $mimeType;
    }
}

// Example usage
$detector = new MimeTypeDetector();
$ftpUrl = 'ftp://username:password@host/path/to/file.txt';
echo $detector->detect($ftpUrl);

?>