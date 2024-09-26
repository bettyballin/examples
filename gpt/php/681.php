
function encryptOrderId($orderId, $encryptionKey, $iv) {
    // Encrypt the order ID using AES-256-CBC
    $encrypted = openssl_encrypt($orderId, 'AES-256-CBC', $encryptionKey, 0, $iv);

    // Convert binary data to hexadecimal
    $hex = bin2
