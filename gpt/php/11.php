
function mixStrings($string1, $string2) {
    $mixed = '';
    $arr1 = str_split($string1);
    $arr2 = str_split($string2);
    $maxLength = max(count($arr1), count($arr2));

    for ($i = 0; $i < $maxLength; $i++) {
        if (isset($arr1[$i])) {
            $mixed .= $arr1[array_rand($arr1)];
        }
        if (isset($arr2[$i])) {
            $mixed .= $arr2[array_rand($arr2)];
        }
    }

    // Optionally shuffle the mixed string for additional randomness
    $mixedArr = str_split($mixed);
    shuffle($mixedArr);
    $mixed = implode('', $mixedArr);

    return $mixed;
}

$string1 = '9cb5jplgvsiedji9mi9o6a8qq1';
$string2 = '5d41402abc4
