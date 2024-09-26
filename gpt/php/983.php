
function removeSensitiveData(&$array, $sensitiveKeys) {
    foreach ($array as $key => &$value) {
        if (is_array($value)) {
            // Recursively apply the same function to the nested array.
            removeSensitiveData($value, $sensitiveKeys);
        } elseif (in_array($key, $sensitiveKeys)) {
            // If the key is sensitive, unset it.
            unset($array[$key]);
        }
    }
    // Unset reference to maintain array integrity.
    unset($value);
}

// Define the keys you consider to be sensitive.
$sensitiveKeys = ['account_no', 'acc_no'];

// Your example arrays.
$array1 = [
    'ClientCode'   => "abcom",
    'MerchantCode' => "Code1",
    'acc_no'       => "12345"
];

$array2 = [
    'customer_name' => "Umesh",
    'age' => 24,
    'customer_details' => [
        'mob_no' => "989
