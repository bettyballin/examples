
   if (!isset($_SERVER['HTTP_X_REQUESTED_WITH']) || strtolower($_SERVER['HTTP_X_REQUESTED_WITH']) != 'xmlhttprequest') {
       // If not a valid Ajax request, exit or redirect
       die('Access Denied'); // Or use `header('Location: somepage.php');`
   }
   
