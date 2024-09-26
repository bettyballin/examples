<?php
$a = '\\';
$b = ' OR 1=1 OR ';
$c = ' --';

$query = "SELECT * FROM t1 WHERE a='" . addslashes($a) . "' AND b='" . addslashes($b) . "' AND c='" . addslashes($c) . "'";
print($query);
?>