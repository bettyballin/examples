<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class YourController extends CI_Controller {

    public function yourMethod()
    {
        $this->load->library('security');
        $user_input = $this->input->post('user_input', TRUE);
        $sanitized_user_input = $this->security->xss_clean($user_input);
    }
}