<?php

if (isset($_POST['submit'])) {
    if (filter_var($_POST['number'], FILTER_VALIDATE_INT) !== false) {
        // Put number in database, or whatever.

        echo "hi";
    }
}

?>

<form action="" method="post">
    <input type="text" name="number">
    <input type="submit" name="submit" value="Submit">
</form>