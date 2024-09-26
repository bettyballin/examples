
   // Start a session
   session_start();

   // Check if the user is logged in and set their role
   if (isset($_SESSION['user_role'])) {
       $userRole = $_SESSION['user_role'];
   } else {
       // Redirect to login page or show an error
       header('Location: login.php');
       exit();
   }
   
