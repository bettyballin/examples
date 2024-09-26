<?php
$userAllowedToSeeImage = true; // or false

if ($userAllowedToSeeImage)
{
    header('Content-Type: image/png');
    readfile('hello.png');
}

else
{
    echo("go away");
}
?>