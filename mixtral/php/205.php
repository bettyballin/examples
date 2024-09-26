<?php
// Example of basic input sanitization and range check

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $name = filter_input(INPUT_POST, 'name', FILTER_SANITIZE_STRING);
    if (empty($name) || strlen($name) > 50){
        echo "Invalid name";
    } else {
        echo "Name: $name";
    }

    // Validate score
    $score = intval($_POST['score']);
    if ($score < 1 || $score > PHP_INT_MAX){
       echo "Invalid or out-of-range score";
    } else {
        echo "Score: $score";
    }
}

// Example form for testing
?>

<form action="" method="post">
    Name: <input type="text" name="name"><br>
    Score: <input type="number" name="score"><br>
    <input type="submit">
</form>