<?php
defined('BASEPATH') or exit('No direct script access allowed');

class YourController extends CI_Controller {

    public function yourMethod() {
        $token_name = $this->security->get_csrf_token_name();
        $hash_value = $this->security->get_csrf_hash();

        $data = array(
            'csrf_name' => $token_name,
            'csrf_hash' => $hash_value
        );

        $this->load->view('your_view_file', $data);
    }
}