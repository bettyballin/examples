<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Test extends CI_Controller {

    public function index()
    {
        $value = $this->input->post('input_field_name', TRUE);
        var_dump($value);
    }
}