<?php
session_start();

if(isset($_SESSION['username'])) {
    echo 'Welcome '. $_SESSION['username'];
} else {
    echo '<a href="login.html">Please Login</a>';
}
?>