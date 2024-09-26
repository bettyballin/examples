
$arr = $_POST['arraywithdata'];

// Validate and sanitize the input
$cleanArr = array_filter($arr, function($value) {
    return is_numeric($value) && (int)$value == $value;
});

// Cast each element to an integer to avoid SQL injection
$cleanArr = array_map('intval', $cleanArr);

// Create a string of placeholders for the prepared statement
$placeholders = implode(", ", array_fill(0, count($cleanArr), '?'));

// Prepare the SQL statement
$stmt = $PDO->prepare("UPDATE `data_s` SET `set` = 1 WHERE `id` IN ($placeholders)");

// Execute the prepared statement with the clean array
$stmt->
