
   session_start();
   if (!isset($_SESSION['username'])) {
       header("Location: main_login.php");
       exit;
   }
   // Rest of your code...
   
