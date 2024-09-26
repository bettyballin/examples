function sendData($data) {
    $nonce = getNonceFromServer();
    $cnonce = hash('sha512', makeRandomString());
    $hash = hash('sha512', $nonce . $cnonce . $data);
    $args = array('data' => $data, 'cnonce' => $cnonce, 'hash' => $hash);
    sendDataToClient($args);
}

// Assuming the following functions are defined elsewhere in the code
function getNonceFromServer() {
    // implementation to get nonce from server
}

function makeRandomString() {
    // implementation to generate a random string
}

function sendDataToClient($args) {
    // implementation to send data to client
}