<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $var = filter_var($_POST['var'], FILTER_SANITIZE_STRING);
    echo $var;
}
?>

<form action="" method="post">
    <input type="text" name="var">
    <input type="submit">
</form>