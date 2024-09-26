<?php
$headers = apache_request_headers();
if ($headers["User-Agent"] == "Mosaic") {
  // code to be executed
  echo "Hello, Mosaic!";
}
?>