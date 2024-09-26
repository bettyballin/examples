<?php

$path_to_executable = '/bin/ls';

$command = [];
$command[] = escapeshellarg($path_to_executable);

if (isset($_GET['arg1'])) {
    if ($_GET['arg1'] > 1000) {
        echo "Error: Please don't specify an 'arg1' higher than 1000.";
        exit(1);
    }
}

$supported_args = ['arg1', 'arg2', 'arg3'];
foreach ($supported_args as $arg) {
    if (isset($_GET[$arg])) {
        $command[] = "--$arg " . escapeshellarg($_GET[$arg]);
    }
}

$command = implode($command, ' ');
echo "Executing $command ...\n";
exec($command . " 2>&1", $result, $return_val);
echo "Returned value: $return_val\n";
echo "Result: " . implode("\n", $result);

?>