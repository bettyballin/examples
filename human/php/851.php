<?php
  // this will allow alphanumeric id's with _ and -. You could alter to only allow numeric by only using [0-9] instead of [a-zA-Z0-9_-]
  $id = $_GET['id'];
  
  if (preg_match('/^[a-zA-Z0-9_-]+$/', $id)) {
    // your embed code here
  } else {
    // handle invalid id
  }
?>