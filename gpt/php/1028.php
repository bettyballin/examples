
   if (isset($_SERVER['HTTP_REFERER']) && parse_url($_SERVER['HTTP_REFERER'], PHP_URL_HOST) == $_SERVER['SERVER_NAME']) {
       // Continue to process the request
   } else {
       // Deny access
       header('HTTP/1.0 403 Forbidden');
       echo "You are not allowed to access this file.";
       exit;
   }
   
