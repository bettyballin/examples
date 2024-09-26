
function decryptAESGCM($key, $iv, $message) {
    $iv = base64_decode($iv);
    $message = base64_decode($message);
   
