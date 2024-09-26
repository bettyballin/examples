<?php
$ctx = stream_context_create([
    'ftp' => [
        'overwrite' => false,
        'ssl' => [
            'verify_peer' => true,
            'cafile' => '/path/to/certificate',
            'CN_match' => 'your.server.com'
        ]
    ]
]);

// Upload a file
$fp = fopen('ftps://user:password@example.com/remote-filename', 'w+b', false, $ctx);
fwrite($fp, file_get_contents('/path/to/local-file'));
fclose($fp);

// Download a file
$fp = fopen('ftps://user:password@example.com/remote-filename', 'r', false, $ctx);
$content = stream_get_contents($fp);
fclose($fp);