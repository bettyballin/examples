<?php
session_start();
if($_SESSION['type']!=1){ 
  die("You are not a buyer. Access denied");
}

// The rest of your page here
?>