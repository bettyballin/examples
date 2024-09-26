
$stmt = $mysqli->prepare("SELECT * FROM jobs WHERE id = ?");
$stmt->bind_param("i", $id); // 'i' denotes the data type is integer
$stmt->execute();
$result = $stmt->get_result();
$row_all = $result->fetch_assoc();

// Do the same for the second query

