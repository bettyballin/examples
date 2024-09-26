
   if (isset($_SERVER['HTTP_REFERER'])) {
       $referer_host = parse_url($_SERVER['HTTP_REFERER'], PHP_URL_HOST);
       if ($referer_host !== $_SERVER['SERVER_NAME']) {
           // Access is not from within the website, handle accordingly
           exit('Access denied');
       }
   } else {
       // No referer sent, handle according to your security policy
       exit('Access denied');
   }
   
