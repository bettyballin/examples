
   // At the start of the script where user is validated
   session_start();
   $_SESSION['user_is_logged_in'] = true;

   // In emailCheck.php
   session_start();
   if (empty($_SESSION['user_is_logged_in'])) {
       die('Access Denied');
   }
   
