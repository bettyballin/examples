
// Assuming $conn is your mysqli connection
$personid = mysqli_real_escape_string($conn, $personid_from_session_or_cookie); // Get this from session or a secure source
$kit = mysqli_real_escape_string($conn, $_GET['id']);

$sql = "SELECT `Who_can_see` FROM `posts` WHERE `post_id` = ?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("s", $
