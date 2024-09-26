<?php
session_start();
if(!isset($_SESSION['submit_flag'])){
   $_SESSION['submit_flag']=true;
   //perform action...
   echo "Action performed!";
}
?>