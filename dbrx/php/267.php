<?php

require_once('Net/SFTP.php');

$sftp = new Net_SFTP('server.com');
if (!$sftp->login('username', 'password')) {
    exit('Login Failed');
}

// Download a file from the remote server to your local machine.
$remote_file_path = '/path/to/your/file/on/server.php';
$local_file_path  = './file_downloaded_from_server.php';

if (!$sftp->get($remote_file_path, $local_file_path)) {
    exit('Failed to download file');
}

echo 'File downloaded successfully!';