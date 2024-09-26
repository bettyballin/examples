<?php
function calculate_password_entropy($password) {
    $characters = str_split($password);
    $probabilities = array_count_values($characters);
    $total_chars = count($characters);
    $entropy = 0;
    foreach ($probabilities as $prob) {
        $p = $prob / $total_chars;
        $entropy -= $p * log($p, 2);
    }
    return round($entropy, 2);
}

$password = "your_password_here";
echo calculate_password_entropy($password);
?>