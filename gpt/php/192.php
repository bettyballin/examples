
   $realIP = $_SERVER['REMOTE_ADDR'];

   if (isset($_SERVER['HTTP_X_FORWARDED_FOR'])) {
       $realIP = $_SERVER['HTTP_X_FORWARDED_FOR'];
   } elseif (isset($_SERVER['HTTP_X_REAL_IP'])) {
       $realIP = $_SERVER['HTTP_X_REAL_IP'];
   }
   
