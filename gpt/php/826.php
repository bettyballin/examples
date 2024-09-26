
function readDiagonally($array) {
    $height = count($array);
    $width = count($array[0]);
    $result = '';
    
    for ($slice = 0; $slice < $width + $height - 1; ++$slice) {
        $z = $slice < $width ? 0 : $slice - $width + 1;
        for ($j = $z; $j <= $slice - $z; ++$j) {
            $i = $slice - $j;
            // Check if the coordinates are within the bounds of the array
            if ($i < $height && $j < $width) {
                $result .= $array[$i][$j];
            }
        }
    }
    
    return $result;
}

// Example usage:
$field = [
    ['l', 'o', 'r', 'e', 'm
