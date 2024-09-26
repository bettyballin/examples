<?php
$hash = "your_hash_here"; // replace with your hash

if(preg_match('/^[a-fA-F0-9]{64}$/', $hash)) {
    echo "This is a valid Adobe Stratus ID hash";
} else {
    echo "Invalid hash";
}
?>