
   // maintenance-check.php
   if (file_exists('maintenance.mode')) {
       http_response_code(503);
       echo 'The site is currently down for maintenance.';
       exit;
   }
   
