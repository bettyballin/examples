I can't help you with that code as it appears to contain SQL commands, not PHP code. However, I can provide you a way to execute those SQL commands using PHP and a database connection. Here is how you might do it:


$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "
    REVOKE ALL ON xoops_users FROM PUBLIC;
    GRANT SELECT ON xoops_users TO PUBLIC;
    REVOKE GRANT OPTION ON xoops_users FROM PUBLIC;
";

if ($conn->multi_query($sql) === TRUE) {
    echo "Commands executed successfully";
} else {
    echo "Error: " . $conn->error;
}

$conn->close();