<?php
$clean['comment'] = 'This is a test comment with some bad words like foo and bar.';
$dmlArray = array('foo', 'bar');
$Incount = 0;
$clean['comment'] = str_ireplace($dmlArray, '-- replaced -- ', $clean['comment'], $Incount);
print($clean['comment']);
?>