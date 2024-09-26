
session_start();

// Assuming $pdo is a PDO instance connected to the database and $member_username is provided by the user
$query = $pdo->prepare("SELECT * FROM users WHERE username = :user");
$query->bindParam(':user', $member_username);
$query->execute();

$row = $query->fetch(PDO::FETCH_ASSOC);

if ($row) {
    // Assuming $member_password is the password provided by the user
