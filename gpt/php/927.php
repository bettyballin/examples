
public function delete_customer($id)
{
    // Begin the transaction
    $this->db->trans_start();

    // Delete from tbl_customer
    $this->db->delete('tbl_customer', array('cus_id' => $id)); 

    // Delete from tbl_additional_details
    $this->db->delete('tbl_additional_details', array('customer_id' => $id));

    // Continue with other tables
    $this->db->delete('tbl_amc_supervisor', array('customer_id' => $id));
    $this->db->delete('tbl_current_issues', array('cr_customer_id' => $id));
    $this->db->delete('tbl_pickmachine', array('customer_id' => $id));
    $this->db->delete('tbl_sales
