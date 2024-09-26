$params = $this->getParams();

$someField = isset($params['someField']) ? $params['someField'] : 'default value';
$someField = $this->sanitizeInput($someField);