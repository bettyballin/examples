<?php

function getParamOrDefault(array &$array, string $key, mixed $defaultValue = null): mixed {
    return isset($array[$key]) ? $array[$key] : $defaultValue;
}

function sanitizeInput(mixed $input): mixed {
    // Add your sanitization logic here
    return $input;
}

class SomeClass {
    private function getParams(): array {
        // Returns a map of params => values sent with HTTP req
        // For demonstration purposes, let's assume we're using $_GET
        return $_GET;
    }

    public function someAction() {
        $params = $this->getParams();

        $someField = getParamOrDefault($params, 'someField', 'default value');
        $someField = sanitizeInput($someField);

        // ...
        echo $someField;
    }
}

$instance = new SomeClass();
$instance->someAction();

?>