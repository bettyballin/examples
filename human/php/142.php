<?php
$found = array("item1", "item2", "item3");
$output = "";

if (!count($found))
{
    $output .= "None.<br/>";
}
else
{
    $output .= "<span class=\"alert\">".implode(', ',$found)."</span>"."</p><br/>";  
}

echo $output;
?>