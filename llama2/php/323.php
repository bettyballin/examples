<?php
function cleanArray($array) {
    foreach ($array as $key => $value) {
        if (is_array($value)) {
            $array[$key] = cleanArray($value);
        } else {
            $array[$key] = trim($value);
        }
    }
    return $array;
}

$array1 = [
    'ClientCode'   => "abcom",
    'MerchantCode' => "Code1",
    'acc_no'       =>  "12345"
];

$cleanedArray1 = cleanArray($array1);
print_r($cleanedArray1);

$array2 = [
    'customer_name' => "Umesh",
    'age' => 24,
    'customer_details' => [
        'mob_no' => "989729069",
        'acc_no' => "12345"
    ]
];

$cleanedArray2 = cleanArray($array2);
print_r($cleanedArray2);
?>