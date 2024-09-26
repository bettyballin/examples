
   session_set_cookie_params([
       'lifetime' => 0, // or an appropriate duration
       'secure' => true,
       'httponly' => true,
       'samesite' => 'Lax' // or 'Strict' depending on your requirements
   ]);
   
