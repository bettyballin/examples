<?php

$args = array('page' =>
    array(
        'filter' => FILTER_VALIDATE_INT,
        'flags'  => FILTER_REQUIRE_SCALAR
    ));

// Using a custom callback
function validateInt($value) {
   $trimmed = trim((string)$value);

    if (ctype_digit($trimmed))
       return intval($trimmed, 10);

    // Return false or null to indicate invalid input
    return null;
}

$args['page']['filter'] = FILTER_CALLBACK;
$args['page']['options'] = 'validateInt';

// Or simply trim the value before validating
$_GET['page'] = trim($_GET['page']);

$ret = filter_input_array(INPUT_GET, $args);

var_dump($ret['page']);

?>