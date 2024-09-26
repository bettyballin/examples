$email = 'your_email@example.com';
$username = 'your_username';
$password = 'your_password';

if (strpos($password, $email) !== false || strpos($password, $username) !== false){
    echo "Password is not valid";
} else {
    echo "Password is valid";
}