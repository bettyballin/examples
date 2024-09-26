
function Password_Match($string, $storedPassword) {
    similar_text($string, $storedPassword, $percent);
    return $percent;
}

$string = "Test";
$pass = "Tesst";
$similarity = Password_Match($string, $pass);

if ($similarity > 75) {
    echo "Alert: Possible brute force attempt!";
} else {
    echo "No significant match found.";
}

