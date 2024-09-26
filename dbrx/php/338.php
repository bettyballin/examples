public function delete_customer($id)
{
    $this->db->trans_start();

    // Delete from tbl_customer table
    $this->db->where('cus_id', $id);
    $this->db->delete('tbl_customer');

    // Prepare an array of tables and their respective conditions for deletion
    $tables = [
        'tbl_additional_details' => ['customer_id' => $id],
        'tbl_amc_supervisor'     => ['customer_id' => $id],
        'tbl_current_issues'     => ['cr_customer_id' => $id],
        'tbl_pickmachine'       => ['customer_id' => $id],
        'tbl_sales'             => ['customer_id' => $id],
        'tbl_service'           => ['customer_id' => $id]
    ];

    // Loop through the tables and delete records based on conditions
    foreach ($tables as $table_name => $conditions) {
        $this->db->where($conditions);
        $this->db->delete($table_name);
    }

    $this->db->trans_complete();

    return $this->db->trans_status();
}