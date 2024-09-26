
function safe_extract(&$array, $flags = EXTR_SKIP, $prefix = null) {
    return extract($array, $flags, $prefix);
}

