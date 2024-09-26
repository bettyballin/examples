<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Example extends CI_Controller {

    public function index()
    {
        $this->db->where('username',$this->session->userdata('uname'));
        $this->db->where('id',$this->session->userdata('uid'));
        $this->db->where('password',md5($this->input->post('old_password')));
        $query = $this->db->get();
        var_dump($query->result());
    }
}



// usage
// example.php
<?php
defined('BASEPATH') OR exit('No direct script access allowed');
require_once 'path/to/codeigniter/system/core/CodeIgniter.php';

$obj = new Example();
$obj->index();