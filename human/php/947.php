$password = 'your_password_here';
$hashToStoreInDb = password_hash($password, PASSWORD_BCRYPT, array("cost" => 11));
echo $hashToStoreInDb;