<?php

header('Content-Type: text/plain;charset=utf-8');
set_time_limit(120);

//define variables
$iLoopCount = 10000;
$aTheArray = array("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
$fStartTime = microtime(true);

//function to convert an array into a string used to create a PHP include file
function convertArrayToInclude(array $aIn) {
  $sOut = 'array(';
  foreach($aIn as $key => $value) {
    $formattedKey = is_string($key) ? "'{$key}'" : $key;
    $formattedValue = is_string($value) ? "'{$value}'" : $value;

    $sOut .= "{$formattedKey} => {$formattedValue},"; 
  }
  $sOut = substr($sOut, 0, -1) . ');';

  return $sOut;
}

//test serialize
for($i = 0; $i < $iLoopCount; $i++) {
  file_put_contents("serialize.txt", serialize($aTheArray), LOCK_EX);
  $aReadArray1 = unserialize(file_get_contents("serialize.txt"));
}

$fStopTime1 = microtime(true);
echo "serialize execution time ({$iLoopCount} iterations) : " . ($fStopTime1 - $fStartTime) . "s\n\n";

//test json_encode
for($i = 0; $i < $iLoopCount; $i++) {
  file_put_contents("json_encode.txt", json_encode($aTheArray), LOCK_EX);
  $aReadArray2 = json_decode(file_get_contents("json_encode.txt"));
}

$fStopTime2 = microtime(true);
echo "json_encode execution time ({$iLoopCount} iterations) : " . ($fStopTime2 - $fStopTime1) . "s\n\n";

//test native using fixed data
for($i = 0; $i < $iLoopCount; $i++) {
  file_put_contents("include.php", 
  '<?php $aReadArray3 = array("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"); ?>'  
  , LOCK_EX);

  include 'include.php';
}

$fStopTime3 = microtime(true);
echo "native include execution time with fixed data ({$iLoopCount} iterations) : " . ($fStopTime3 - $fStopTime2) . "s\n\n";

//test native using dynamic data
for($i = 0; $i < $iLoopCount; $i++) {
  file_put_contents("include2.php", 
  '<?php $aReadArray4 = ' . convertArrayToInclude($aTheArray) . ' ?>'  
  , LOCK_EX);

  include 'include2.php';
}

$fStopTime4 = microtime(true);
echo "native include execution time with dynamic data ({$iLoopCount} iterations) : " . ($fStopTime4 - $fStopTime3) . "s\n\n";

?>