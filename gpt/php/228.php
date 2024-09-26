
   session_start();
   setcookie(session_name(), session_id(), [
       'secure' => true,
       'httponly' => true,
       'samesite' => 'Strict', // If supported, to prevent CSRF attacks.
   ]);
   
