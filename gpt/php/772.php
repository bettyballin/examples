
// Hashing a password
function password_encrypt($password)
{
    return password_hash($password, PASSWORD_BCRYPT);
}

// Ver
