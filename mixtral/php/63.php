<?php
$output = "<input type='" . htmlspecialchars($this->type, ENT_QUOTES) . "' name='" . htmlspecialchars($this->name, ENT_QUOTES) . "'>";
$output .= "></input>";
echo $output;
?>