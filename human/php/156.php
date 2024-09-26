<?php
$basedir   = dirname(__FILE__);
$filename  = realpath($_SERVER['DOCUMENT_ROOT'].$_GET['file']);
if (substr($filename,0,strlen($basedir)) !== $basedir) {
  header ("HTTP/1.0 403 Forbidden"); 
  exit; 
} else {
  // your executable code here
  readfile($filename);
}
?>