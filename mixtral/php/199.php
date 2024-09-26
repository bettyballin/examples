<?php

class MyController extends AppController {

    public $components = [
        'Security' => [
            'csrfUseOnce' => false
        ]
    ];

    protected $_unlockedActions = ['login', 'logout'];

    public function beforeFilter() {
        parent::beforeFilter();

        if (in_array($this->action, $this->_unlockedActions)) {
            // Unlock the action
            $this->Security->config('unlockedActions', [$this->request->params['action']]);
        }
    }
}