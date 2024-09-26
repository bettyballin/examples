<?php
function cleanArray($array) {
    foreach ($array as $key => $value) {
        if (in_array($key, ['account_no', 'acc_no'])) {
            unset($array[$key]);
        } elseif (is_array($value)) {
            $array[$key] = cleanArray($value);
        }
    }

    return $array;
}

// Example usage:
$array = [
    'name' => 'John',
    'account_no' => '12345',
    'address' => [
        'street' => '123 Main St',
        'city' => 'Anytown',
        'acc_no' => '67890'
    ]
];

$cleanedArray = cleanArray($array);
print_r($cleanedArray);
?>