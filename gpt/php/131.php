
   $stmt = $pdo->prepare("SELECT * FROM your_table WHERE page = :page");
   $stmt->bindParam(':page', $page, PDO::PARAM_INT);
   $page = (int) $_GET['page'];
