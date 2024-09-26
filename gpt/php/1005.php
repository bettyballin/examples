
   session_start();
   session_regenerate_id();
   // Set cookie parameters to be secure
   $cookieParams = session_get_cookie_params();
   session_set_cookie_params(
       $cookieParams["lifetime"],
       $cookieParams["path"],
       $cookieParams["domain"],
       true, // Secure flag
       true  // HttpOnly flag
   );
   
