
$result = mysqli_fetch_assoc(mysqli_query($conn, $query));
$hashedPassFromDb = $result['password'];
$pass = $_POST['password'];

