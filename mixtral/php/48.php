public function beforeFilter(){
    parent::beforeFilter();

    // Disable CSRF protection for contact action
    if (in_array($this->action, ['contact'])) {
        $this->Security->csrfCheck = false;

        // Or disable ValidatePost
        $this->Security->validatePost = false;

        // or allow specific request method
        $this->Security->requireSecure();
    }
}