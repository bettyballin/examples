<?php
if( count($_POST, COUNT_RECURSIVE) == ini_get("max_input_vars")){
    // Your code here
    echo "Maximum number of input variables reached.";
}
?>