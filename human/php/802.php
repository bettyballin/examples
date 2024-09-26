<?php
session_start();
if(!isset($_SESSION['authenticate']))
{
    echo "You are not allowed to access";
}
else { echo "You came from index.php ! so you are a valid user"; }
session_destroy();
?>