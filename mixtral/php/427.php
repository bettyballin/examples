<?php

function isSensitiveData($data) {
    // Your logic here

    if(is_string($data)){
        return strpos($data, 'password') !== false;
    }

    return false;
}

// Usage

try{
    throw new Exception("Error");
} catch (Exception $e) {
    echo "Caught exception: ",  $e->getMessage(), "\n";
}

$data = 'mysecretpassword';
echo var_export(isSensitiveData($data), true) . "\n";

?>