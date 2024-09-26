<?php

class accesswrapper {
    private $token;

    public function __construct($params) {
        // Generate a unique token
        $this->token = bin2hex(random_bytes(32));

        // Create an instance of the appropriate subclass
        switch ($params['ticket']) {
            case 'subclass1':
                $instance = new subclass1($params);
                break;
            case 'subclass2':
                $instance = new subclass2($params);
                break;
            default:
                throw new Exception('Invalid ticket');
        }

        // Set the token on the instance
        $instance->setToken($this->token);

        return $instance;
    }

    public function getToken() {
        return $this->token;
    }
}

class subclass1 {
    private $token;

    public function __construct($params) {}

    public function setToken($token) {
        $this->token = $token;
    }

    public function getToken() {
        return $this->token;
    }
}

class subclass2 {
    private $token;

    public function __construct($params) {}

    public function setToken($token) {
        $this->token = $token;
    }

    public function getToken() {
        return $this->token;
    }
}

// Example usage
$params = array('ticket' => 'subclass1');
$instance = new accesswrapper($params);
echo $instance->getToken();

?>