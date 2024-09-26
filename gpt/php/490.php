
function ssl_installed() {
    $hostname = $_SERVER['HTTP_HOST'];
    $connection = @stream_socket_client("ssl://{$hostname}:443", $errno, $errstr, 30);

    if ($connection === false) {
        return false;
    } else {
        fclose($connection);
        return true;
