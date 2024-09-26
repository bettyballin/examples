
   // Assuming $sql is a valid MySQLi connection object
   $stmt = $sql->prepare("UPDATE customers SET name = ? WHERE id = ?");
   $stmt->bind_param("si", $name, $id); // 's' for string, 'i' for integer
   $stmt->execute();
   
