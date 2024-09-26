<?php
$required_fields = array('nombre', 'apellidos');
$campos = new stdClass();

// assuming $campos has some properties, for example:
$campos->nombre = 'John';
$campos->apellidos = 'Doe';

foreach($required_fields as $required) {
    if(property_exists($campos, $required)) {
        echo "The field $required exists.\n";
    } else {
       throw new Exception("Whoops the field $required does not exist in the response from the server.");
    }
}
?>