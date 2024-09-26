<?php
define('BASE_URL', 'http://example.com');

class Error {
    private $code;

    public function setCode($code) {
        $this->code = $code;
    }

    public function getCode() {
        return $this->code;
    }
}

class Main {
    public $error;

    public function __construct() {
        $this->error = new Error();
    }

    public function run() {
        $this->error->setCode('404');

        if (($this->error->getCode()) == '404') {
            ob_clean();

            // Validate the URL before using it
            if (filter_var(BASE_URL . '/404.html', FILTER_VALIDATE_URL)) {
                echo file_get_contents(BASE_URL . '/404.html');
            } else {
                throw new Exception('Invalid URL: ' . BASE_URL . '/404.html');
            }
        }
    }
}

$main = new Main();
$main->run();
?>