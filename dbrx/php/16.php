function authenticateUser($userName, $givenPassword, $link)
{
    // Prepare statement for authentication check
    if ($stmt = mysqli_prepare($link, "SELECT `password` FROM `login` WHERE userid = ? LIMIT 1")) {
        // Bind parameters to the prepared statement
        mysqli_stmt_bind_param($stmt, 's', $userName);

        // Execute query with user-provided input (username)
        mysqli_stmt_execute($stmt);
        
        // Get result set from executed statement
        if ($result = mysqli_stmt_get_result($stmt)) {
            // Fetch password hash for the given username
            while ($row = mysqli_fetch_assoc($result)) {
                $retrievedPassword = $row['password'];
                
                // Verify provided password against stored hash
                return password_verify($givenPassword, $retrievedPassword);
            }
        }

        // Close statement and free resources
        mysqli_stmt_close($stmt);

    } else {
        echo "Error preparing authentication query.";
        
        // Log error or handle it appropriately for your application
    }

    // Return false if no matching user was found or an error occurred during the process
    return false;
}