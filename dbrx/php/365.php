<?php

function removeSensitiveData($data) {
    $sensitiveKeys = ['account_no', 'acc_no']; // Add more keys as needed

    foreach ($data as $key => &$value) { // Use reference (&$value)
        if (is_array($value)) {
            $value = removeSensitiveData($value);
        } elseif (in_array(strtolower(trim($key)), array_map('strtolower', $sensitiveKeys))) {
            unset($data[$key]); // Remove the sensitive key-value pair
        }
    }

    return $data;
}

$array1 = [
    'ClientCode'   => "abcom",
    'MerchantCode' => "Code1",
    'acc_no'       => "12345"
];

$array2 = [
    'customer_name'  => "Umesh",
    'age'            => 24,
    'customer_details' => [
        'mob_no'   => "989729069",
        'account_no'=> '1235'
    ]
];

$result1 = removeSensitiveData($array1);
$result2 = removeSensitiveData($array2);

print_r($result1); 
print_r($result2); 

?>