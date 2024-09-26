$stmt = $pdo->prepare('SELECT COUNT(*) FROM users WHERE email = :email');
$stmt->bindParam(':email', $_POST['newsletter_email']);
$stmt->execute();
$is_user = (bool) $stmt->fetchColumn();