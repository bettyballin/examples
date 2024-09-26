<?php
foreach (array(
    'name',
    'address',
    'somethingelse',
    'ect'
) as $key) {
    $$key = isset($_POST[$key]) ? $_POST[$key] : null;
}

// Test the code
$_POST['name'] = 'John Doe';
$_POST['address'] = '123 Main St';

foreach (array(
    'name',
    'address',
    'somethingelse',
    'ect'
) as $key) {
    $$key = isset($_POST[$key]) ? $_POST[$key] : null;
}

print_r(get_defined_vars());
?>