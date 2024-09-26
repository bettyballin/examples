<?php
defined('BASEPATH') or exit('No direct script access allowed');

class YourController extends CI_Controller
{
    public function yourMethod()
    {
        $this->load->library('form_validation');

        // Set rules for form fields
        $this->form_validation->set_rules('name', 'Name', 'required|alpha_numeric_spaces');
        $this->form_validation->set_rules('gsm', 'GSM', 'required|numeric|min_length[10]|max_length[15]');

        if ($this->form_validation->run() == FALSE) {
            // Handle validation errors
            $this->load->view('your_view');
        } else {
            $name = $this->input->post('name');
            $gsm = $this->input->post('gsm');

            // Escape special characters in strings that will be used as SQL queries
            $escaped_name = $this->db->escape_str($name);
            $escaped_gsm = $this->db->escape_str($gsm);

            $insert = array(
                'name' => $escaped_name,
                'gsm'  => $escaped_gsm
            );

            // Insert data into database
            $this->db->insert('your_table', $insert);

            // Redirect to success page
            redirect('success_page');
        }
    }
}