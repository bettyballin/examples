
<?php
function genKey($q, $seed) {
    // Use HMAC with SHA256 to generate a keyed hash value
    $p = hash_hmac('sha256', $q, $seed);
    return $p;
}

function checkKey($p, $q, $seed) {
    // Generate a new keyed hash with the original seed and compare it with the provided hash
    $newP = genKey($q, $seed);
    return hash_equals($p, $newP);
}

// Usage
$q = 'some_hash_value_like_md5_or_sha'; // This is your input hash
$seed = 'secret_seed_string'; // This is your secret seed/key

$p = gen
