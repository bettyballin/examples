<?php 
$webresults = 
'
{  "aliceblue": "#f0f8ff",
  "antiquewhite": "#faebd7",
  "aqua": "#00ffff",
  "aquamarine": "#7fffd4",
  "azure": "#f0ffff",
  "beige": "#f5f5dc",
  "bisque": "#ffe4c4",
  "black": "#000000"
}';

$decoded = json_decode($webresults, true);
echo htmlentities(json_encode($decoded));
?>