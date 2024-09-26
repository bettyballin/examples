<?php

$input = "testusername123"; // Replace with your input

$username = trim($input);
if(preg_match('/^[a-zA-Z0-9]+$/', $username)) {
    echo "Valid username";
}
else{
   echo "Invalid username";
}

?>