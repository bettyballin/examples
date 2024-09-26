$password = $_POST["password"];

if (substr($pwInDatabase, 0, 1) == "$")
{
    if (password_verify($password, $pwInDatabase))
    {
        // Password is valid
    }
    else
    {
        // Password is not valid
    }
}
else
{
    // User still using the old MD5, update it!

    if (md5($password) == $pwInDatabase)
    {
        $db->storePw(password_hash($password, PASSWORD_DEFAULT));
    }
    else
    {
        // Password is not valid
    }
}