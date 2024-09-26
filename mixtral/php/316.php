<?php
session_start();
if ($_POST["token"] !== $_SESSION["token"]) {
    // code to handle invalid token
} else {
    // code to handle valid token
}
?>