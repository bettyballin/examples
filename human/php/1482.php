function concat($arr1, $arr2) {
    $newArr = array_merge($arr1, $arr2);
    return $newArr;
}

// Test the function
$arr1 = unpack('C*', "Hello");
$arr2 = unpack('C*', "World");
$result = concat($arr1, $arr2);
print_r($result);