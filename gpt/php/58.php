
// Safe: Using prepared statements with parameter binding
$stmt = $conn->prepare("SELECT * FROM users WHERE id = ?");
$stmt->bind_param("s", $_GET['id']); // 's' specifies the variable type => 'string'
$stmt->execute();
$result = $stmt->get_result();

