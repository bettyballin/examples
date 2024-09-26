public function beforeFilter() {
    parent::beforeFilter();

    if($this->request->params['action'] === 'kassareturn') {
        $this->Security->csrfCheck = false;
        $this->Security->validatePost = false;
    }
}