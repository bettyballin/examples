
public function __construct() {
    parent::__construct();

    if (!$this->session->userdata('is_logged_in')) {
        // Redirect to login page with a proper redirection status code
        redirect('login', 'refresh');
    }
}

