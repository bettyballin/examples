
   $allowed_domains = ['example.com', 'sub.example.com', 'anotherdomain.com'];
   $host = $_SERVER['HTTP_HOST'];
   
   if (in_array($host, $allowed_domains)) {
       // Host is valid
   } else {
       // Host is not recognized, handle the error
   }
   
