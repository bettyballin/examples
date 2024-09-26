&lt;?php
class Example {
    public function getParam($param, $default) {
        // Simulating getting a parameter
        $params = array('someField' => 'example value');
        return isset($params[$param]) ? $params[$param] : $default;
    }

    public function execute() {
        $someField = $this-&gt;getParam('someField', 'default value');
        print($someField);
    }
}

$example = new Example();
$example-&gt;execute();
?&gt;