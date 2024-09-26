<?php
function findInStr($string, $findarray){
    $found=false;   
    for($i=0;$i<sizeof($findarray);$i++){
        $res=strpos($string,$findarray[$i]);
        if($res !== false){
            $found=true;
            break;
        }
    }
    return $found;
}

// Example usage:
$string = "Hello, World!";
$findarray = array("World", "Universe", "Galaxy");
$result = findInStr($string, $findarray);
print($result ? "Found" : "Not Found");
?>