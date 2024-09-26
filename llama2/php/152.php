<?php
function passwordCorrect($userName, $givenPassword, $link) {
    $result = mysqli_query($link, 'SELECT `password`
                        FROM `login`
                        WHERE userid = \''.$userName.'\' LIMIT 1');

    if (mysqli_num_rows($result) === 0) {
        return false;
    }

    $retrievedPassword = mysqli_fetch_array($result);
    if (password_verify($givenPassword, $retrievedPassword['password'])) {
        return true;
    }

    return false;
}

// example usage
$link = mysqli_connect("localhost", "username", "password", "database");
if (!$link) {
    die("Connection failed: " . mysqli_connect_error());
}

$userName = 'example_user';
$givenPassword = 'example_password';

echo passwordCorrect($userName, $givenPassword, $link) ? 'Password is correct' : 'Password is incorrect';

mysqli_close($link);
?>