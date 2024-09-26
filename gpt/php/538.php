
   public function beforeFilter() {
       parent::beforeFilter();
       $this->Security->unlockedActions = array('contact');
   }
   
