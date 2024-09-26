
   $stmt = $mysqli->prepare("SELECT * FROM your_table WHERE page = ?");
   $stmt->bind_param("i", $page); // 'i' specifies the data type is integer
   $page = (int) $_GET['page'];
   $stmt->execute();
   $result = $stmt->get_result();
   
