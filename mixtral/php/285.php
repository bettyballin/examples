<?php

function isBase64($data) {
    return preg_match('/^[a-zA-Z0-9\/\r\n+]*={0,2}$/', $data);
}

$id = '...'; // Your Elasticsearch ID
if (isBase64($id)) {
  echo "Valid Base64";
} else {
  echo "Invalid Base64";
}

?>