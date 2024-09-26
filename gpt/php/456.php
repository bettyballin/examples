
   // Allow only specific domain
   $allowed_domain = 'https://www.example.com';

   if (isset($_SERVER['HTTP_ORIGIN']) && $_SERVER['HTTP_ORIGIN'] === $allowed_domain) {
       header('Access-Control-Allow-Origin: ' . $allowed_domain);
       header('Access-Control-Allow-Methods: POST');
       // other headers...
   } else {
       header('HTTP/1.1 403 Forbidden');
       exit;
   }
   
