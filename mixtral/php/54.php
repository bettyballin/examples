<?php

$pdo = new PDO('mysql:host=localhost;dbname=test', 'username', 'password');

if($_POST['submit'] == 'Login') {
    $err = array();

    if(!$_POST['username'] || !$_POST['password']) {
        $err[] = 'All the fields must be filled in!';
    }

    if(count($err) == 0) {
        $stmt = $pdo->prepare("SELECT idusr, password FROM members WHERE usr=:username");
        $stmt->execute(['username' => $_POST['username']]);

        if ($row = $stmt->fetch()) {
            if (password_verify($_POST['password'], $row['password'])) {
                // Login successful
                echo "Login successful!";
            } else {
                $err[] = 'Invalid password!';
            }
        } else {
            $err[] = 'Invalid username!';
        }
    }

    if(count($err) > 0) {
        foreach($err as $error) {
            echo $error . "<br>";
        }
    }
}

?>
<form action="" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username"><br><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br><br>
    <input type="submit" name="submit" value="Login">
</form>