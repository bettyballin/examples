
   $this->db->select('*');
   $this->db->from('my_table');
   $this->db->where('my_column', $my_value); // Automatically escapes $my_value
   $query = $this->db->get();
   
