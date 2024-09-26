<?php
if (isset($_POST['submit'])) {
    $number = $_POST['number'];
    if (filter_var($number, FILTER_VALIDATE_INT) !== false) {
        echo "Input is a number and can be processed/stored safely.";
    } else {
        echo "Invalid input. Please enter a valid number.";
    }
}
?>

<form action="" method="post">
    <input type="text" name="number" placeholder="Enter a number">
    <input type="submit" name="submit" value="Submit">
</form>