<?php
$error = false;
if (isset($_POST['submit'])) {
    $member_username = $_POST['username'];
    $form_password = $_POST['password'];

    try {
        $dbh = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');
        $dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        $query = $dbh->prepare("SELECT * FROM users WHERE username = :user");
        $query->bindParam(':user', $member_username);
        $query->execute();
        $row = $query->fetch();

        if (!$row || !password_verify($form_password, $row['password'])) {
            $error = true;
        } else {
            if ($row['activated'] > 0) {
                $options = array('cost' => 12);
                $algorithm = PASSWORD_BCRYPT;
                if (password_needs_rehash($row['password'], $algorithm, $options)) {
                    $hash = password_hash($row['password'], $algorithm, $options);
                    // Store new hash in db
                    $update_query = $dbh->prepare("UPDATE users SET password = :hash WHERE user_id = :id");
                    $update_query->bindParam(':hash', $hash);
                    $update_query->bindParam(':id', $row['user_id']);
                    $update_query->execute();
                }
                $_SESSION["user_id"] = $row['user_id'];
                header("location: login_success.php");
                exit;
            } else {
                echo "Account not activated wait for system administrator!";
            }
        }
    } catch (PDOException $e) {
        echo 'Connection failed: ' . $e->getMessage();
    }
}

if ($error) {
    echo "Please Check username and password field!";
} elseif (isset($_POST['submit'])) {
    echo "Wrong password or username please <a href='index.php'><b>Retry!</b></a>";
}
?>