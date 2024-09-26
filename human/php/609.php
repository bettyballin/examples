<?php
$pass = (isset($argv[2]))?$argv[2]:"";
if ($pass != 'your password')
{
die('Password is incorrect!');
}
?>