php
<?php
try {
    $dbh = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');
    $dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $sth = $dbh->prepare("SELECT * FROM mmh_user_info WHERE email_address = ?");
    $sth->execute(array($_REQUEST['email_address']));
    $red = $sth->fetchAll();
    print_r($red);
} catch (PDOException $e) {
    echo 'ERROR: ' . $e->getMessage();
}
?>