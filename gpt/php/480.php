
function authenticateUser($userName, $givenPassword, $link)
{
    $result = mysqli_query($link, 'SELECT `password`
                        FROM `login`
                        WHERE `userid` = \''.mysqli_real_escape_string($link, $userName).'\' LIMIT 1');

    if ($result && mysqli_num_rows($result) == 1) {
        $retrievedPassword = mysqli_fetch_array($result);

        if (password_verify($givenPassword, $retrievedPassword['password'])) {
            return 'log in successful!';
        }
    }

    return 'Authentication failed';
}

