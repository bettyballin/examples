
$ID = isset($_GET["id"]) ? (int)$_GET["id"] : 0; // Default to 0 if not set

$query = "SELECT `col1`, `col2`, `col3` FROM `table` WHERE `ID` = ?";

if ($stmt = mysqli_prepare($connection, $query)) {
    mysqli_stmt_bind_param($stmt, "i
