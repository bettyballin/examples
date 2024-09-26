<?php
$aUrl = 'http://localhost/test';
if( preg_match( "/^(http:\/\/)(localhost|127.0.0.1|".$_SERVER["SERVER_ADDR"]."|".$_SERVER["HTTP_HOST"]."|www.yourhost.net)/i", $aUrl )) die( 'error' );
echo "Success";
?>