<?php
function password_match($string, $storedPassword){
    similar_text($string, $storedPassword, $percent);

    return (int) ($percent);
}

$string = "Test";
$pass = "TeStt";
echo password_match($string, $pass)."%";
?>