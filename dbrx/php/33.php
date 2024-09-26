<?php
defined('BASEPATH') or exit('No direct script access allowed');

class Example extends CI_Controller {

    public function index() {
        ?>
        <form action="<?php echo base_url('example/submit'); ?>" method="post">
            <input type="hidden" name="<?php echo $this->security->get_csrf_token_name(); ?>" value="<?php echo $this->security->get_csrf_hash(); ?>">
            <input type="text" name="example_input" placeholder="Enter something">
            <button type="submit">Submit</button>
        </form>
        <?php
    }

    public function submit() {
        if ($this->security->csrf_verify() === FALSE) {
            show_error('CSRF verification failed');
        } else {
            $input = $this->input->post('example_input');
            // Process $input here
            echo 'Submission successful';
        }
    }
}