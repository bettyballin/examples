<?php 
    $allowed_functions = ['strlen', 'strpos']; // add more safe functions to the list

    if (isset($_POST['code']) && is_string($_POST['code'])) {
        $function_name = $_POST['code'];
        
        if (in_array($function_name, $allowed_functions)) {
            echo "Result: ";
            echo call_user_func($function_name, 'example string');
        } else {
            die('Error: Function not allowed.');
        }
    }
?>