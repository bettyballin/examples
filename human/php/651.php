<?php
session_start();

if( !isset( $_SESSION[ 'isLogged' ] ) ) {
    header( 'Location: login.php' );
    exit;
}
?>