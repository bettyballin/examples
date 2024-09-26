
// Instead of md5, use password_hash
$hashedPassword = password_hash($_POST['password'], PASSWORD_DEFAULT);
$qry = "INSERT INTO accounts(username, firstname, lastname, password) VALUES ('$username', '$fname', '$lname', '$hashedPassword')";

