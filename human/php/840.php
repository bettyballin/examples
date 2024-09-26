<?php

class MyClass {
    public function getSecretKey($controller = null, $action = null)
    {
        $salt = Mage::getSingleton('core/session')->getFormKey();

        $p = explode('/', trim($this->getRequest()->getOriginalPathInfo(), '/'));
        if (!$controller) {
            $controller = !empty($p[1]) ? $p[1] : $this->getRequest()->getControllerName();
        }
        if (!$action) {
            $action = !empty($p[2]) ? $p[2] : $this->getRequest()->getActionName();
        }

        $secret = $controller . $action . $salt;
        return Mage::helper('core')->getHash($secret);
    }

    // Mocked getRequest method for demonstration purposes
    public function getRequest()
    {
        return new class {
            public function getOriginalPathInfo()
            {
                return '/path/to/controller/action';
            }

            public function getControllerName()
            {
                return 'controller';
            }

            public function getActionName()
            {
                return 'action';
            }
        };
    }
}

// Create an instance of MyClass and call getSecretKey method
$obj = new MyClass();
echo $obj->getSecretKey();