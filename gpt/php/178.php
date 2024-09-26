
   session_set_cookie_params([
       'lifetime' => 0, // or any other lifetime
       'path' => '/',
       'domain' => $_SERVER['HTTP_HOST'],
       'secure' => true, // set to true if using HTTPS
       'httponly' => true,
      
