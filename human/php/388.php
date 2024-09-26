<?php
$myvar = preg_replace("/[^a-zA-Z0-9-]/","",$_GET['var']);
print($myvar);
?>