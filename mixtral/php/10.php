<?php
$key = "your_key_here";
$ending = "your_ending_here";
$position = 0;
$j = 0;
$output_text = "";

$output_text .= chr(ord($key{$position}) ^ ord($ending{$j}));

print($output_text);
?>