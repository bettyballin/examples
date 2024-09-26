$searchValue = filter_input(INPUT_GET, 'major', FILTER_SANITIZE_STRING);
$key = array_search($searchValue, $slugs);

if ($key !== false) {
    // Value found in slugs array.
    echo "Value found in slugs array.";
} else {
    // Value not found or invalid input provided.
    echo "Value not found or invalid input provided.";
}