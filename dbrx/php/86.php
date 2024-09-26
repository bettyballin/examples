$allowedValues = [0 => '', 1 => '-fluid'];
$conType = (int)$this->params->get('conType', 0);

if (!array_key_exists($conType, $allowedValues)) {
    $conType = 0; // Set default value if input is invalid
}

$classValue = "container{$allowedValues[$conType]}";