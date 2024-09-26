
   // Using MySQLi
   $stmt = $mysqli->prepare("INSERT INTO feedback (user_agent, referrer) VALUES (?, ?)");
   $stmt->bind_param('ss', $_SERVER['HTTP_USER_AGENT'],
