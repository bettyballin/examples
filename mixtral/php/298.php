<?php
$inputJSONString = '{"key": "value"}'; // example JSON string
$data = json_decode($inputJSONString, TRUE);
if ($data === NULL){
    echo "Invalid JSON";
}
else {
    echo "Valid JSON";
    print_r($data);
}
?>