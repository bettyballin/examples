<?php

// configuration
$dbHost = 'localhost';
$dbUser = 'your_username';
$dbPassword = 'your_password';
$dbName = 'your_database_name';

// create connection
$dbConnection = mysqli_connect($dbHost, $dbUser, $dbPassword, $dbName);

// check connection
if (!$dbConnection) {
    die("Connection failed: " . mysqli_connect_error());
}

/* create a prepared statement */
if ($stmt = mysqli_prepare($dbConnection, "INSERT INTO `table` (`1`, `2`, `3`) VALUES (?, ?, ?)"))
{

    /* bind parameters for markers */
    mysqli_stmt_bind_param($stmt, "sss", $_POST[1], $_POST[2], $_POST[3]);

    /* execute query */
    if(mysqli_stmt_execute($stmt))
    {
        echo "Successfully inserted " . mysqli_affected_rows($dbConnection) . " row";
    }
    else
    {
        echo "Error occurred: " . mysqli_error($dbConnection);
    }

    /* close statement */
    mysqli_stmt_close($stmt);
}

// close connection
mysqli_close($dbConnection);

?>