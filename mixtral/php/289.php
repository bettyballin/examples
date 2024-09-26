<?php

$data = 'a:2:{i:0;s:1:"b";i:1;d:2;}'; // serialized array

// Unserializing the data
if (is_string($data) && preg_match('/^[ais]:/', $data)) {
    $unserialized = unserialize($data);

    if (!empty($unserialized) && is_array($unserialized)) {
        // Process your array here
        print_r($unserialized);

    } else {
        throw new Exception('Invalid serialized data');
    }
} else {
    echo "Invalid data";
}

?>