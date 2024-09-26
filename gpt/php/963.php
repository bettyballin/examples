
   if ($_SERVER['REMOTE_ADDR'] !== $_SERVER['SERVER_ADDR']) {
       exit('Unauthorized access.');
   }
   
