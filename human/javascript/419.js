<?php
session_start();
if (isset($_SESSION['authorized']) && $_SESSION['authorized']) {
  // the user can do the secret stuff
  echo "You are authorized!";
} else {
  // the user cannot do the secret stuff
  echo "You are not authorized!";
}
?>