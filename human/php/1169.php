<?php
// encrypt.php
if(isset($_POST['encrypt'])) {
    $text = $_POST['text'];
    $encrypted_text = base64_encode($text);
    echo "Encrypted String: $encrypted_text";
}
?>

<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
<form method="POST" action="encrypt.php">
Original String <input type="text" name="text">
<input type="submit" name="encrypt" value="Encrypt">
</form>
</body>
</html>