
// Assuming $db is a mysqli connection object
$email = $_POST['newsletter_email'];
$email = filter_var($email, FILTER_SANITIZE_EMAIL);

// Prepare a statement
$stmt = $db->prepare('SELECT COUNT(*) FROM users WHERE email = ?');
$stmt->bind_param('s', $email); // 's' specifies the variable type => 'string'

// Execute the query
$stmt->execute();

// Store the result so we can get the row count
$stmt->store_result();

$is_user = $stmt->num_rows > 0; // true if one or more rows are returned
