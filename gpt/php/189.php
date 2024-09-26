
   $sql = "SELECT * FROM some_table WHERE some_column = :some_value";
   $this->db->query($sql, array('some_value' => $value));
   
