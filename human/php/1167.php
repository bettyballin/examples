<?php

if(isset($_POST['encrypt'])){
    $string = $_POST['ostring'];
    $encrypted_string = base64_encode($string);
    echo "Encrypted string: $encrypted_string";
}
else if(isset($_POST['decrypt'])){
    $encrypted_string = $_POST['ostring'];
    $decrypted_string = base64_decode($encrypted_string);
    echo "Decrypted string: $decrypted_string";
}

?>

<form method="post">
    <input type="text" name="ostring" placeholder="Enter string">
    <button type="submit" name="encrypt">Encrypt</button>
    <button type="submit" name="decrypt">Decrypt</button>
</form>