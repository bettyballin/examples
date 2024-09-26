<?php
session_start();
if (!isset($_SESSION['submitted']))
{
  // do whatever you want to do
  die();    // stop further execution
}

$filename = "download.pdf";
if(ini_get('zlib.output_compression'))ini_set('zlib.output_compression', 'Off');
header("Pragma: public");
header("Expires: 0");
header("Cache-Control: must-revalidate, post-check=0, pre-check=0");
header("Cache-Control: private", false);
header("Content-Type: application/pdf");
header("Content-Disposition: attachment; filename=\"$filename\"");
header("Content-Transfer-Encoding: binary");
header("Content-Length: ".filesize($filename));
readfile($filename);
exit;
?>