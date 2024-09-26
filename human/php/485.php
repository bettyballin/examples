<?php
if (isset($_POST['submit'])) {
    if (empty($_POST['aa']) || $_POST['aa'] != 'bb') {
        echo "Bot detected!";
    } else {
        echo "Welcome, human!";
    }
}
?>

<form action="" method="post">
    <input type="text" name="aa">
    <input type="submit" name="submit" value="Submit">
</form>