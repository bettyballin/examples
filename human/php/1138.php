<?php
// make sure form was submitted
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    echo "Form submitted!";
}
?>

<form action="" method="post">
    <input type="submit" value="Submit">
</form>