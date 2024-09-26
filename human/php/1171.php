<?php
$key = "thisismykey12345";

if(isset($_POST['decrypt'])){
    $encrypted = $_POST['encrypted'];

    $data = base64_decode($encrypted);
    $iv = substr($data, 0, mcrypt_get_iv_size(MCRYPT_RIJNDAEL_128, MCRYPT_MODE_CBC));

    $decrypted = rtrim(
        mcrypt_decrypt(
            MCRYPT_RIJNDAEL_128,
            hash('sha256', $key, true),
            substr($data, mcrypt_get_iv_size(MCRYPT_RIJNDAEL_128, MCRYPT_MODE_CBC)),
            MCRYPT_MODE_CBC,
            $iv
        ),
        "\0"
    );
}
?>

<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
<form method="POST" action="<?php echo $_SERVER['PHP_SELF']; ?>">
    Encrypted String <input type="text" name="encrypted" style="width:500px;"><br><br>
    <input type="submit" name="decrypt" value="Decrypt">
    Decrypted String <input type="text" name="decrypted" style="width:500px;" value="<?php echo  $decrypted; ?>">
</body>
</html>