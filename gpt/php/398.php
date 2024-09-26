
   $allowed_hosts = ['www.yoursite.com', 'yoursite.com'];
   $referer_host = parse_url($_SERVER['HTTP_REFERER'], PHP_URL_HOST);

   if (in_array($referer_host, $allowed_hosts)) {
       // Continue with the redirect.
   } else {
       // Block the redirect or redirect to a default page.
   }
   
