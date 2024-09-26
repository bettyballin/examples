<?php
$predefined_password = "4815162342";
if ($_GET['pass'] != $predefined_password){
  die('Access Denied!');
}
?>