<?php
  if(!$user->isLoggedIn()) {
    // do 404
    header('HTTP/1.0 404 Not Found');
    exit;
  }
?>