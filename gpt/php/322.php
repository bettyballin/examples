
$this->db->select('*');
$this->db->from('Users');
$this->db->where('Username', $username);
$query = $this->db
