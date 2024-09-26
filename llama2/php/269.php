<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Controller extends CI_Controller {

    public function index() {
        $input = $this->security->xss_clean($this->input->post());
        $this->session->set_userdata('user_input', $input);
    }
}