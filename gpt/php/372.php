
class MY_Controller extends CI_Controller {
    public function __construct() {
        parent::__construct();
        $this->check_session();
    }

    private function check_session() {
        if (!$this->session->userdata('logged_in')) {
            // User is not logged in, redirect to login page
            redirect('login');
        }
    }
}

class Dashboard extends MY_Controller {
    public function index() {
        $this->load->view('my_view');
        // Additional code
    }

    public function function1() {
        // run some code
    }

    private function
