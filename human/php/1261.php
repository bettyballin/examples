<?php
function parse_ini_file_quotes_safe($f) {
    $r = null;
    $sec = null;
    $f = @file($f);
    for ($i = 0; $i < @count($f); $i++) {
        $newsec = 0;
        $w = @trim($f[$i]);
        if ($w) {
            if ((!$r) or ($sec)) {
                if ((@substr($w, 0, 1) == "[") and (@substr($w, -1, 1) == "]")) {
                    $sec = @substr($w, 1, @strlen($w) - 2);
                    $newsec = 1;
                }
            }
            if (!$newsec) {
                $w = @explode("=", $w);
                $k = @trim($w[0]);
                unset($w[0]);
                $v = @trim(@implode("=", $w));
                if ((@substr($v, 0, 1) == "\"") and (@substr($v, -1, 1) == "\"")) {
                    $v = @substr($v, 1, @strlen($v) - 2);
                }
                if ($sec) {
                    $r[$sec][$k] = $v;
                } else {
                    $r[$k] = $v;
                }
            }
        }
    }
    return $r;
}

// Example usage:
$ini_file = 'example.ini';
$parsed_ini = parse_ini_file_quotes_safe($ini_file);
print_r($parsed_ini);
?>