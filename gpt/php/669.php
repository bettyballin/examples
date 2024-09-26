
   public function beforeFilter() {
       parent::beforeFilter();
       if ($this->request->params['action'] === 'kassareturn') {
           // Unlock specific fields if necessary
           $this->Security->unlockedFields = array
