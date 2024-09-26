<?php
function sterilize(&$val,$key)
{
    //do whatever security you need here
    $val = trim($val);
    $val = strip_tags($val);
    //etc
    $val = htmlspecialchars($val);
}
$bad_values = explode(',',$_GET['tags']);
array_walk($bad_values,'sterilize');
print_r($bad_values);
?>