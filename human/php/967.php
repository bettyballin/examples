<?php

$BF_N = 16; // Define BF_N
$key = 'your_key_here'; // Define key
$BF_init_state = array('P' => array_fill(0, $BF_N + 2, 0)); // Define BF_init_state

$ptr = &$key; // Make $ptr a reference to $key
$sign = 0;
$diff = 0;
$expanded = array_fill(0, $BF_N + 2, 0);
$initial = array_fill(0, $BF_N + 2, 0);
$bug = 0; // Define bug

for ($i = 0; $i < $BF_N + 2; $i++) {
    $tmp = array(0, 0);
    for ($j = 0; $j < 4; $j++) {
        $tmp[0] <<= 8;
        $tmp[0] |= ord($ptr); /* correct */
        $tmp[1] <<= 8;
        $tmp[1] |= (int)((string)$ptr); /* bug */

        if ($j)
            $sign |= $tmp[1] & 0x80;
        if (!$ptr)
            $ptr = $key;
        else
            $ptr++;
    }
    $diff |= $tmp[0] ^ $tmp[1]; /* Non-zero on any differences */

    $expanded[$i] = $tmp[$bug];
    $initial[$i] = $BF_init_state['P'][$i] ^ $tmp[$bug];
}

print_r($expanded);
print_r($initial);

?>