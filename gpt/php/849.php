
// Assuming $mysqli is a valid mysqli connection object
// and $user_input is the input you are getting from the user

$stmt = $mysqli->prepare("SELECT * FROM table WHERE column = ?");
$stmt->bind_param("s", $user_input); // 's' specifies the variable type => 'string'
$stmt->execute();

$result = $stmt->get_result();
while ($row = $result->fetch_assoc()) {
    // ... process the results ...
}
$stmt->close();

