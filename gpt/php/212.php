
   session_start();
   if (!isset($_SESSION['user_logged_in'])) {
       // Redirect to login page or show an error
       header('Location: login.php');
       exit;
   }
   
