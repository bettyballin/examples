<?php
$var = "I\'m testing. Not funny.";
echo $var;                 // --> I\'m testing. Not funny.
echo stripslashes($var);   // --> I'm testing. Not funny.
?>