
   $sql = "SELECT * FROM my_table WHERE my_column = ?";
   $this->db->query($sql, array($my_value)); // Escapes $my_value
   
