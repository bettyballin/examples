
   session_start();
   if (!isset($_SESSION['userID']) || $_SESSION['userID'] == '') {
       header("Location: login.php");
       exit(); // Very important to prevent further script execution
   }
   
