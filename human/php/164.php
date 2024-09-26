<?php
$str = 'a:1:{s:3:"foo";s:3:"bar";}';
if (preg_match('/^a:[0-9]+:{/', $str) 
&& !preg_match('/(^|;|{|})O:\+?[0-9]+:"/', $str)) {
    echo "Match found!";
} else {
    echo "No match found!";
}
?>