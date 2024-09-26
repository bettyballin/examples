
   if (isset($_SERVER['HTTP_REFERER']) && parse_url($_SERVER['HTTP_REFERER'], PHP_URL_HOST) == $_SERVER['SERVER_NAME']) {
       // Proceed with processing the request
   } else {
       // Deny the request
       header('HTTP/1.0 403 Forbidden');
       exit;
   }
   
