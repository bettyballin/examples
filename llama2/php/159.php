<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class MyController extends CI_Controller {
    public function __construct() {
        parent::__construct();
        $this->load->library('security');
    }

    public function index() {
        // Generate CSRF token
        $token = $this->security->hash($this->input->ip_address());

        // Render form with CSRF token
        $data['token'] = $token;
        $this->load->view('myform', $data);
    }

    public function submitForm() {
        // Verify CSRF token
        $token = $this->input->post('token');
        if (!$this->security->verify_hash($token, $this->input->ip_address())) {
            echo 'Invalid request';
            exit;
        }

        // Process form data
        // ...
    }
}

Note: Make sure you have CodeIgniter framework installed and configured properly, and the 'myform' view file exists in the views directory.