
$data = '...'; // This is the serialized string
$allowed_classes = []; // An empty array means no objects are allowed, only arrays

try {
    $result = unserialize($data, ['allowed_classes' => $allowed_classes]);
    if (is_array($result)) {
        // The result is an array and can be safely used
    } else {
        // The result is not an array; handle this case as needed
    }
} catch (Exception $e) {
    // Handle exception in case of unserialize error
}

