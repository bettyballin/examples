
session_start(); 
session_regenerate_id(true); 
$new_session_id = session_id(); 
// Save the new_session_id into the database
$_SESSION['user_ip'] = $_SERVER['REMOTE_ADDR'];

// then on every page, check $_SESSION['user_ip'] and session_id against the database field

