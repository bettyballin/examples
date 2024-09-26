
$insert_data_array = array(
    'username' => 'johndoe',
    'password' => 'mypassword' // Assuming this is already hashed
);

$this->db->insert('users', $insert_data_array);

