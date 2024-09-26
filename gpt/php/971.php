
$password = "123456789";
$salt = "123456";
$iterations = 1000;

// Initial hash with password and salt
$hash = hash('sha256', $salt . $password);

// Apply the hash function iteratively
for ($i = 1; $i < $iterations; $i++) {
    $hash = hash('sha256', $hash);
}

echo 'PHP equivalent result: ' . $hash;

