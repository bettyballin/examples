
// Set the max lifetime of the session
ini_set('session.gc_maxlifetime', 30*24*60*60); // 30 days

// Start the session
session_start();

// Set a cookie with the session ID that expires in 30 days
setcookie(session_name(), session_id(), time() + 30*24*60*60);

