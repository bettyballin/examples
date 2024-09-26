
// Assuming $mysqli is a mysqli object connected to the database
$stmt = $mysqli->prepare("SELECT * FROM Benutzer WHERE Benutzername = ? AND Password = ?");
$hashedPassword = md5($PW); // As a side note, consider using password_hash() and password_verify() instead
$stmt->bind_param("ss", $Benutzer, $hashedPassword);
$stmt->execute();
$result = $stmt->get_result();
// ... Fetch your data

