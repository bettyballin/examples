<?php
class MyClass {
    public function getKey()
    {
        return 'form-login';
    }
}

$obj = new MyClass();
echo $obj->getKey();
?>