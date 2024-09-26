<?php    
// Important, ONLY allow the indices you really want to support
function array_key_whitelist($array, $whitelist) {
    return array_intersect_key($array, array_flip($whitelist));
}

$whitelist = array_key_whitelist($_POST, [
    'foo',
    'bar', 
    'baz',
    'moo',
    'usr',
    'lol'
]);
// Then run extract() as expected
extract($whitelist, EXTR_SKIP);