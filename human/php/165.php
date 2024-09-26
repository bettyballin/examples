<?php
function addOne(&$number){
    $number = $number + 1;
}

$myNumber = 3;
addOne($myNumber);
echo $myNumber;
?>