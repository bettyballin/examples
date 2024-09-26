
$descriptorspec = array(
   0 => array("pipe", "r"),  // stdin is a pipe that the child will read from
   1 => array("pipe", "w"),  // stdout is a pipe that the child will write to
);

$process = proc_open('/usr/bin/python /path/to/someScript.py', $descriptorspec, $pipes
