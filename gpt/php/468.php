
$password = 'userPassword123!'; // The password submitted by the user.
$hash = password_hash($password, PASSWORD_DEFAULT); // This will create a hash using bcrypt and automatically generate a salt.

