<?php

$messages = array(
    (object)array('message' => 'Hello, world!')
);

$attachment = true;
$filePath = '/path/to/your/file.txt';

$data = [
    'msg' => $messages[0]->message
];

if ($attachment) {
    // Assuming that the path to your file is correct
    $filePath = realpath($filePath);
    $data['attachment'] = $filePath;
}

print_r($data);

?>