<?php
session_start();
if ($_SESSION['okToViewImage']) {
  $fn = $_GET['fn'];
  $type = explode('.',$fn);
  header('Content-Type: image/' . end($type)); 
  echo file_get_contents('dirOutsideWWWpubScope/'. $fn);
  exit;
}
?>