<?php
start_session();
if(isset($_SESSION['userLoggedIn'])){
    require 'public_html/logged_in.php';
}else{
    require 'public_html/public_area.php';
}
?>