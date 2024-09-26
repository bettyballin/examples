<?php
   session_start();
   if(isset($_POST['csrfKey']) && isset($_SESSION['csrfKey'])) {
      if($_POST['csrfKey'] != $_SESSION['csrfKey']) {
         die("Unauthorized source!");
      }
   } else {
      die("Missing CSRF key!");
   }
?>