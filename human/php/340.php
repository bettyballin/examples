<?php
require_once('../inc/db/dbc.php');

$entPass =  $_POST['userPass']; 
$SaltyPass = hash('sha512',mysql_real_escape_string($dynamSalt).mysql_real_escape_string($entPass));

$NewUserLoginCheck = mysql_query("
    SELECT uUName, uEmail, uUPass, dynamSalt 
    FROM User 
    WHERE (uUName = '".mysql_real_escape_string($_POST['userOrEmail'])."' OR  uEmail = '".mysql_real_escape_string($_POST['userOrEmail'])."') 
    AND uUPass = sha2(concat(dynamSalt, '".mysql_real_escape_string($_POST['userPass'])."'), 512)
")or die(mysql_error());
?>