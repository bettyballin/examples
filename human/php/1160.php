<?php
  else if(basename($_SERVER['PHP_SELF']) != "login.php") {
             echo "<div class='head1'> You are not logged in<br> Please <a href='login.php'>Login</a></div>";
             exit;
        }
?>