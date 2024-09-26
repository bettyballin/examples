<?php

if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    echo "Error: This page only accepts POST requests.";
    exit;
}

// Process the form data here...
echo "Form data received successfully!";

?>
<form action="" method="post">
    <input type="text" name="username" placeholder="Username">
    <input type="password" name="password" placeholder="Password">
    <input type="submit" value="Submit">
</form>