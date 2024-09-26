
function is_sha1($str) {
    return (bool) preg_match('/^[0-9a-f]{40}$/i', $str);
}

function is_stratus_id($str) {
    // Assuming Adobe Stratus ID follows a specific pattern, adjust the regex as needed
    return (bool) preg_match('/^[0-9a-zA-Z-_]{64}$/', $str);
}

$inputs = array_merge($_GET, $_POST); // Combine GET and POST
$safe_inputs = array(); // Array to hold the safe, filtered variables

foreach ($inputs as $key => $value) {
    // Check for SHA1 hash
    if (is_sha1($value)) {
        $safe_inputs[$key] = $value;
    } 
    //
