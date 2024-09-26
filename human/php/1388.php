<?php 
$input = '<script>alert("vulnerable");</script>';
echo  htmlentities($input); //not vulnerable to external input code injection scripts
?>