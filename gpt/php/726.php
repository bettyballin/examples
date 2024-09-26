
if (password_verify($password, $user->pass)) {
    echo 'good';
} else {
    echo 'kill';
}

