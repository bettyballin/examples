<?php
rename_function('require', 'internal_require');
override_function('require', '$filename', 'print "require called"; internal_require($filename);');

// test the overridden function
require 'test.php';

function rename_function($original_name, $new_name) {
    $args = func_get_args();
    array_shift($args);
    array_shift($args);
    return call_user_func_array('runkit_function_rename', $args);
}

function override_function($function_name, $parameters, $code) {
    return runkit_function_add($function_name, $parameters, $code);
}
?>