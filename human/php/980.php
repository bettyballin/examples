<?php
try {
    $dbh = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');
    $dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $sql = "SELECT * FROM users WHERE username = ?";
    $stmt = $dbh->prepare($sql);
    $result = $stmt->execute([$_POST['username']]);
    $users = $stmt->fetchAll();

    if (isset($users[0])) {
        if (password_verify($_POST['password'], $users[0]->password)) {
            // valid login
            echo "Valid login";
        } else {
            // invalid password
            echo "Invalid password";
        }
    } else {
        // invalid username
        echo "Invalid username";
    }
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
}
?>