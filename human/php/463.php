<?php
$username = "user123";
$password = "pass123";

if (isset($_POST["text"])) {
    $text = $_POST["text"];

    $url = "http://example.com/foo.php";
    $data = "text=".$text."&password=".md5($password)."&username=".$username;

    $handle = curl_init($url);
    curl_setopt($handle, CURLOPT_POST, true);
    curl_setopt($handle, CURLOPT_POSTFIELDS, $data);
    curl_setopt($handle, CURLOPT_RETURNTRANSFER, true);
    $result = curl_exec($handle);
    curl_close($handle);

    if($result) {
        echo "Success";
    } else {
        echo "Failed";
    }
} else {
    echo "No text provided";
}
?>
<form action="" method="post">
    <input type="text" name="text" />
    <input type="submit" />
</form>