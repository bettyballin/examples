
     $rawQuery = '/thisisa"quote/helloworld/';
     $safeQuery = urlencode($rawQuery);
     $canonicalURL = "https://www.yourdomain.com" . $safeQuery;
     
