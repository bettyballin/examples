
$result = mysqli_query($connection, $query);

if (!$result) {
    error_log("Database error: " . mysqli_error($connection));
