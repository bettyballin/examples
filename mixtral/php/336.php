public function delete_customer($id)
{
    $this->db->trans_start();

    // Delete from tbl_customer
    $this->db->where('cus_id', $id);
    $this->db->delete('tbl_customer');

    // Delete from other tables
    foreach (['additional_details', 'amc_supervisor', 'current_issues', 'pick_machine', 'rsalesservice'] as $table) {
        $this->db->where('customer_id', $id);
        $this->db->delete("tbl_{$table}");
    }

    // If the transaction was successful commit it
    if ($this->db->trans_status() === FALSE){
        $this->db->trans_rollback();
        return false;
    } else {
        $this->db->trans_complete();
        return true;
    }
}