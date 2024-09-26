<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $profile = $_POST["profile"];
    $link = $_POST["link"];
    // You can add your logic here to process the form data
    echo "Profile: $profile<br>Link: $link";
}
?>

<input type="text" placeholder="Enter URL" onkeyup="document.getElementById('link').value=(this.value).replace(/https?:/,'')">

<form method="post">
<input name="profile" type="text" placeholder="Enter name"/>
<input name="link" id='link' type="hidden">
<input type="submit">
</form>