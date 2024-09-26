<?php

if (isset($_POST['encrypt'],$_POST['ostring'])) {
    $ostring = $_POST['ostring'];
    $encrypted_string = base64_encode($ostring);
    echo "Encrypted String: " . $encrypted_string;
}

if (isset($_POST['decrypt'],$_POST['encrypted_string'])) {
    $encrypted_string = $_POST['encrypted_string'];
    $decrypted_string = base64_decode($encrypted_string);
    echo "Decrypted String: " . $decrypted_string;
}

?>

<form action="" method="post">
    <input type="text" name="ostring" placeholder="Enter original string">
    <input type="submit" name="encrypt" value="Encrypt">
</form>

<form action="" method="post">
    <input type="text" name="encrypted_string" placeholder="Enter encrypted string">
    <input type="submit" name="decrypt" value="Decrypt">
</form>