
   session_start();

   // Generate a token for the form
   if (empty($_SESSION['csrf_token'])) {
       $_SESSION['csrf_token'] = bin2hex(random_bytes(32));
   }

   // Include the token in the form
   echo '<form method="post" action="submit.php">';
   echo '<input type="hidden" name="csrf_token" value="' . htmlspecialchars($_SESSION['csrf_token']) . '">';
   // ... other form fields ...
   echo '</form>';

   // Verify the token on form submission in submit.php
   if (!empty($_POST['csrf_token']) && hash_equals($_SESSION['csrf_token'], $_POST['
