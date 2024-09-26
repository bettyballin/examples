<?php
class Block {
    public function escapeHtml($string) {
        return htmlspecialchars($string, ENT_QUOTES, 'UTF-8');
    }
}

class Request {
    private $params = array();

    public function getParam($key) {
        return isset($this->params[$key]) ? $this->params[$key] : null;
    }

    public function setParam($key, $value) {
        $this->params[$key] = $value;
    }
}

class Main {
    private $request;

    public function __construct() {
        $this->request = new Request();
    }

    public function getRequest() {
        return $this->request;
    }
}

$main = new Main();
$main->getRequest()->setParam('city', 'New York');

$block = new Block();
$city = $main->getRequest()->getParam('city');
?>

<div>
    City: <?php echo $block->escapeHtml($city); ?>
</div>