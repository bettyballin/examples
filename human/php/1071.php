class Test {
    private $params = array('someField' => 'example value');

    public function getParam($key, $default = null) {
        return isset($this->params[$key]) ? $this->params[$key] : $default;
    }

    public function run() {
        $someField = $this->getParam('someField', 'default value');
        echo $someField;
    }
}

$test = new Test();
$test->run();