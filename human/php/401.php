<?php

defined('BASEPATH') or exit('No direct script access allowed');

class Main_controller extends MY_Controller
{
    public function __construct() 
    {
        parent::__construct(); 
    }

    public function index()
    {
        $this->load->view('my_view');
        //run some code
    }

    public function function1()
    {
        $this->load->model('my_model');
        // run some code
    }
}