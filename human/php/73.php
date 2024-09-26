<?php
  $tmpPath = $_FILES["file"]["tmp_name"];
  $name = $_FILES["file"]["name"];
  move_uploaded_file($tmpPath, "/home/user/www/protected/$name");
?>