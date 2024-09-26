<?php
class Example {
    public $params;

    function __construct() {
        $this->params = new stdClass();
        $this->params->conType = 'fluid'; // replace with your value
    }

    function execute() {
        $conType = $this->params->conType;
        if (!in_array($conType, ['fluid'])) {
            echo "Invalid input";
        } else {
            echo "Valid input";
        }
    }
}

$example = new Example();
$example->execute();
?>