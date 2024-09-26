
function pdoSet($fields, &$values) {
    $set = '';
    $values = array();
    foreach ($fields as $key => $value) {
        $set .= "`".str_replace("`","``",$key)."`" . "= :".$key.", ";
        $values[$key] = $value;
    }
    return rtrim($set, ", ");
}

function update_user($update_data) {
    global $pdo;
    $values = array(); // This will contain the values for the placeholders

    // Build the SET part of the SQL statement and the $values array
    $sql = "UPDATE users SET " . pdoSet($update_data, $values) . " WHERE user_id = :user_id";
    $stm = $pdo->prepare($sql);

    // Add the user_id
