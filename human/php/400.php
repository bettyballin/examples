<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class MY_Controller extends CI_Controller
{
    public function __construct() 
    {
        parent::__construct();

        if ( ! isset($_SESSION["user"]) OR empty($_SESSION["user"]))
        {
            // User not logged in - so send them to the home page
            redirect ("/");
        }
    }
}