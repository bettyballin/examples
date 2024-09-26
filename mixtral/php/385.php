<?php

function removeSensitiveData(&$arr) {
    $search = ['account_no', 'acc_no']; // add more sensitive keys here

    array_walk($arr, function (&$value, &$key) use ($search) {
        if (in_array(strtolower($key), $search)) unset($arr[$key]);

        else if (is_array($value)){
            removeSensitiveData($value);

            // If the array is empty after removing sensitive data
            // then we should also delete this key from parent

            if(empty($value) && !in_array($key, ['customer_details'])){
                unset($arr[$key]);
            }
        }
    });
}

// Usage
$yourArray = [
    'account_no' => '12345',
    'acc_no' => '67890',
    'customer_details' => [
        'name' => 'John Doe',
        'address' => '123 Main St'
    ],
    'other_data' => [
        'account_no' => '34567',
        'more_data' => 'hello world'
    ]
];

removeSensitiveData($yourArray);

print_r($yourArray);

?>