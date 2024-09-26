
    session_start();

    // Check if the user is logged in and has a valid user type.
    if (!isset($_SESSION["u_type"]) || !in_array($_SESSION["u_type"], [1, 2, 3
