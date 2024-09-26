public function beforeFilter(){
    parent::beforeFilter();

    // Allow contact form to be submitted without security check
    if (in_array($this->action, ['contact'])) {
        $this->Security->unlockedActions = array($this->action);
    }
}