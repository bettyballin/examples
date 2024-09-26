$password = 'your_password_here';
$rawSha1Password = base64_decode(hash('sha1', $password, true));