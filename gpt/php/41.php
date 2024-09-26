
$allowed_hosts = ['example.com', 'sub.example.com'];
$host = $_SERVER['HTTP_HOST'];

if (!in_array($host, $allowed_hosts)) {
    // Host is not recognized, use a default or handle
