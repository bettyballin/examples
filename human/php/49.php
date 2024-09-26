function stmt_bind_assoc (&$stmt, &$out) {
    $data = mysqli_stmt_result_metadata($stmt);
    $fields = array();
    $out = array();

    $fields[0] = $stmt;
    $count = 1;

    while($field = mysqli_fetch_field($data)) {
        $fields[$count] = &$out[$field->name];
        $count++;
    }
    call_user_func_array('mysqli_stmt_bind_result', $fields);
}

// example usage
$mysqli = new mysqli("localhost", "user", "password", "database");
$stmt = $mysqli->prepare("SELECT * FROM table");
$stmt->execute();
stmt_bind_assoc($stmt, $row);
while ($stmt->fetch()) {
    print_r($row);
}