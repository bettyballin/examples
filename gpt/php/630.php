
$ftp_host = 'ftp-12345678.mywebhoster.com'; // Your FTPS host
$ftp_user = 'your_username'; // Your FTP username
$ftp_pass = 'your_password'; // Your FTP password
$remote_file = 'somefile.txt';
$local_file = 'localfile.txt';

// Setup stream context for SSL
$context = stream_context_create([
    'ssl' => [
        'verify_peer' => true,
        'verify_peer_name' => true,
        'allow_self_signed' => false,
        'cafile' => '/path/to/cacert.pem', // Path to a CA-bundle file
    ]
