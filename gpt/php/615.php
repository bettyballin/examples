
// Create a socket
$socket = socket_create(AF_INET, SOCK_STREAM, SOL_TCP);

// Bind the socket to localhost and a specific port
if (!socket_bind($socket, '127.0.0.1', $port)) {
    die('Unable to bind to localhost');
}

// Start listening for connections
socket_listen($socket);

