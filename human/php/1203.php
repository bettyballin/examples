<?php

$result = [
    ["'a'=('a'='b')", "('a'='a')='b'", "true='b'", "'a'=false"],
    ["1", "0", "0", "1"]
];

print "+---------------+---------------+----------+-----------+\n";
foreach ($result as $row) {
    print "| " . implode(" | ", array_map(function($value) { return str_pad($value, 15, " ", STR_PAD_BOTH); }, $row)) . " |\n";
}
print "+---------------+---------------+----------+-----------+\n";

?>