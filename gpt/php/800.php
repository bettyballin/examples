
setcookie(session_name(), session_id(), [
    'expires' => time() + 86400, // 1 day
    'path' => '/',
    'domain' => '', // your domain
    'secure'
