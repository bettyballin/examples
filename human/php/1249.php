<?php
if (preg_match('|\.?my-site.com$|', $_SERVER['SERVER_NAME'])) {
   header("Access-Control-Allow-Origin: {$_SERVER['HTTP_ORIGIN']}");
   header('Vary: Origin,Accept-Encoding');
}
?>