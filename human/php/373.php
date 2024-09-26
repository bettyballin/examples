<?php
class MyController extends Zend_Controller_Action {

    public function init() {
    }

    public function indexAction() {
        //instantiate DbTable Model and execute FetchAll returns Rowset object
        //call ->toArray() for array to be returned: $model->fetchAll()->toArray();
        $model = new Application_Model_DbTable_MyTable();
        $data = $model->fetchAll()->toArray();
        var_dump($data);
    }
}