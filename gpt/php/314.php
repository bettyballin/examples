
session_start();

// Generate a hashed session name
$sessionName = 'sess_' . hash('sha256', $_SERVER['REMOTE_ADDR'] . $_SERVER['HTTP_USER_AGENT']);
session_name($sessionName);

