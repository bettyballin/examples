public function showusers() {
    if(!isset($_SERVER['HTTP_X_REQUESTED_WITH']) || strtolower($_SERVER['HTTP_X_REQUESTED_WITH']) != 'xmlhttprequest') { 
        show_404();
        exit;
    }

    // continue with processing
}