<?php
function mix_strings($string1, $string2) {
    $mixed_string = '';
    $max_length = max(strlen($string1), strlen($string2));
    for ($i = 0; $i < $max_length; $i++) {
        if ($i < strlen($string1)) {
            $mixed_string .= $string1[$i];
        }
        if ($i < strlen($string2)) {
            $mixed_string .= $string2[$i];
        }
    }
    return $mixed_string;
}

$string1 = 'Hello';
$string2 = 'World';

$mixed_string = mix_strings($string1, $string2);
print($mixed_string . "\n");
?>