
$allowed_redirects = array(
    'account/blah',
    'account/dashboard',
    // ... other allowed paths
);

if (isset($this->session->data['redirect'])) {
    $redirect_path = parse_url($this->session->data['redirect'], PHP_URL_PATH);
    if (in_array($redirect_path, $allowed_redirects)) {
        $this->redirect($this->session->data['redirect']);
    } else {
        // Redirect to a default page or show an error
    }
}

