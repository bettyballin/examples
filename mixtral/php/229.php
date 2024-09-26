<?php

class MyController extends AppController {

    public function beforeFilter() {
        $this->Security->disabledFields = ['field1', 'field2']; // Disable protection for certain fields

        parent::beforeFilter();
    }

    public function index() {
        // Or
        $this->Security->csrfCheck = false;

        // Or
        $this->Security->validatePost = false;
    }
}