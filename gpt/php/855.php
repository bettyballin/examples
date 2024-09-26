
   $stmt = $mysqli->prepare("SELECT column FROM table WHERE id = ?");
   $stmt->bind_param("s", $id
