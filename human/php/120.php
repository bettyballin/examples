<?php
function entropy($string) {
   $h=0;
   $size = strlen($string);
   foreach (count_chars($string, 1) as $v) {
      $p = $v/$size;
      $h -= $p*log($p)/log(2);
   }
   return $h;
}

// Test the function
$string = "Hello, World!";
echo "Entropy: " . entropy($string);
?>