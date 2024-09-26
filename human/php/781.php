<?php
$keywords=filter_var($_POST['keywords'], FILTER_SANITIZE_STRING);
?>
<form action="" method="post">
    <input type="text" name="keywords" placeholder="Enter keywords">
    <input type="submit" value="Submit">
</form>