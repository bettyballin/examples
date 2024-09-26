
// Assuming $sql is a valid mysqli connection object
$stmt = $sql->prepare("INSERT INTO Persons (msg, ip, time, main, twit, city, lat, lon, lang) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

// Sanitize and validate inputs as necessary before binding
$ip = filter_var($_SERVER['REMOTE_ADDR'], FILTER_VALIDATE_IP);
$date = date('Y-m-d H:i:s'); // Use the server time or validate the user input for time
$msg = filter_input(INPUT_POST, 'msg', FILTER_SANITIZE_STRING);
$main = filter_input(INPUT_POST, 'main', FILTER_SANITIZE_STRING);
$twit = filter_input(INPUT_POST, 'twit', FILTER_SANITIZE_STRING);
$city = filter_input(INPUT_POST, 'city', FILTER_SANITIZE_STRING);
$lang = filter_input(INPUT_POST, 'lang', FILTER
