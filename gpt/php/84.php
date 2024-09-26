
$port      = escapeshellarg($_GET['ssh_port']);
$host      = escapeshellarg($_GET['ssh_host']);
$username  = escapeshellarg($_GET['ssh_username']);

$command = sprintf('ssh -p %s %s@%s', $port, $username, $host);
$answer = shell_exec($command);

