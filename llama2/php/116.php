<?php
if (!filter_var($_SERVER["HTTP_HOST"], FILTER_VALIDATE_IP, FILTER_FLAG_NO_RESOLVE) && $_SERVER["SERVER_PORT"] == 80) {
   header("HTTP/1.1 301 Moved Permanently");
   header("Location: https://" . $_SERVER["SERVER_NAME"] . $_SERVER["REQUEST_URI"]);
   exit();
}
?>