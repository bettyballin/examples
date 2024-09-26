
   <?php
   session_start();
   if (isset($_SESSION['loggedIn']) && $_SESSION['loggedIn']) {
       header('Content-Type: application/javascript');
       readfile('path/to/your/secure-javascript.js');
   } else {
       header('HTTP/1.0 403 Forbidden');
       echo 'You are not authorized to view this file.';
       exit;
   }
   ?>
   
