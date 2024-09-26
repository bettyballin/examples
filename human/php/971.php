<?php
class Example {
    private function _validateFormKey() {
        // Your validation logic here
        return true; // or false
    }

    public function test() {
        if (!$this->_validateFormKey()) {
            exit();
        }
        echo "Form key is valid";
    }
}

$example = new Example();
$example->test();
?>