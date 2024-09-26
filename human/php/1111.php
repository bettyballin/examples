<?php
$var = filter_var($_GET['var'], FILTER_VALIDATE_REGEXP,
array("options"=>array("regexp"=>"/^[a-zA-Z0-9]+$/")));

if($var!==false) {
  $command = escapeshellarg($var);
  exec("bash -c \"$command\"", $output, $return_var);
  print_r($output);
}
?>