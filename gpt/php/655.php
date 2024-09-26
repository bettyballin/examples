
$hostname = filter_input(INPUT_POST, 'hostname', FILTER_VALIDATE_DOMAIN, FILTER_FLAG_HOSTNAME);
$port = filter_input(INPUT_POST, 'port', FILTER_VALIDATE_INT, array("options" => array("min_range" => 1, "max_range" => 65535)));

if (!$hostname || !$port) {
    // Handle validation error
}

$mysqli = new mysqli($hostname, $_POST['username'], $_POST['password'], '', $port
