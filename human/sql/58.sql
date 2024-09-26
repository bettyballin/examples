php
$stmt = $dbh->prepare("SELECT * FROM userdata WHERE UserName=:user AND Password=PASSWORD(:pass)");
$stmt->bindParam(':user', $user);
$stmt->bindParam(':pass', $pass);
$stmt->execute();