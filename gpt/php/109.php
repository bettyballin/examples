
function generateSpinner($entryId) {
    $timestamp = time();
    $clientIP = $_SERVER['REMOTE_ADDR'];
    $secret = 'your_secret_string'; // Replace this with your secret string.
    $spinner = md5($timestamp . $clientIP . $entryId . $secret);
    return $spinner;
}

function hashFieldName($fieldName, $spinner) {
    $secret = 'your_field_name_secret'; // Replace this with another secret.
    return md5($fieldName . $spinner . $secret);
}

