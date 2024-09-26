<?php
$a = "\xbf";
$b = " OR 1=1 OR ";
$c = " --";

$query = "SELECT * FROM t1 WHERE a='$a' AND b='$b' AND c='$c'";
print($query);
?>