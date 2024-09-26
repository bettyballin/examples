<?php

$links = array(
   0 => "http://www.example.com/link1.html",
   1 => "http://www.example.com/link2.html",
   // Add as many links as you want here...
);

if (isset($_GET['id'])) {
   $id = $_GET['id'];
   if(array_key_exists($id, $links)) {
      $content = file_get_contents($links[$id]);
      echo $content;
   } else {
      echo "Invalid ID";
   }
} else {
   echo "No ID provided";
}

?>