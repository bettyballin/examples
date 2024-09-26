<?php

class Model {
    public function load($data) {
        $allowedFields = ['name', 'is_admin']; 
        $inputData = array_intersect_key($data, array_flip($allowedFields));

        if (empty($inputData)) {
            return false;
        }

        return $this->parentLoad($inputData);
    }

    private function parentLoad($data) {
        // simulate parent::load() method
        return $data;
    }
}

$model = new Model();
$data = ['name' => 'John', 'is_admin' => true, 'other_field' => 'value'];
$result = $model->load($data);
print_r($result);

?>