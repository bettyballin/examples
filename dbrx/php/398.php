$stmt->bind_param('s', $the_id);
$the_id = $_GET['id'];
$stmt->execute();
$result = $stmt->get_result();

if ($result->num_rows > 0) {
    // Execute the delete statement here
    $delete_stmt = $conn->prepare("DELETE FROM your_table_name WHERE id = ?");
    $delete_stmt->bind_param('s', $the_id);
    $delete_stmt->execute();
} else {
    header("Location: error_page.php");
    exit;
}