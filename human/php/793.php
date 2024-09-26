<?php
// the hash stored for the user
$given_hash = '$5$rounds=10000$3ES3C7XZpT7WQIuC$BEKSvZv./Y3b4ZyWLqq4BfIJzVHQweHqGBukFmo5MI8';
$test_pw = 'password123';

// extract the hashing method, number of rounds, and salt from the stored hash
// and hash the password string accordingly
$parts = explode('$', $given_hash);
$test_hash = crypt($test_pw, sprintf('$%s$%s$%s$', $parts[1], $parts[2], $parts[3]));

// compare
echo $given_hash . "\n" . $test_hash . "\n" . var_export($given_hash === $test_hash, true);
?>