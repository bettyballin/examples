<?php
function get_iv($base, $size, $seq) {
    $remaining = $size;
    $round = 0;
    $iv = '';
    while ($remaining != 0) {
        $d = md5($base . $seq . $round, true);
        $len = min($remaining, 16);
        $iv .= substr($d, 0, $len);
        $remaining -= $len;
        $round++;
    }
    return $iv;
}

// Example usage
$base = 'example_base';
$size = 32;
$seq = 'example_sequence';
echo get_iv($base, $size, $seq);
?>