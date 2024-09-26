<?php
$found = ""; // initialize variable
$output = ""; // initialize variable

if ($found == "")
{
    $output .= "None.<br/>";
}
else
{
    $output .= "<span class=\"alert\">".substr($found, 0, -2)."</span>"."</p><br/>";  // cuts trailing comma and space from $found
}

print $output;
?>