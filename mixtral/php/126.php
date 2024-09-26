<?php
$path = '/path/to/your/jarfile/'; // replace with actual path
$command = ['java', '-cp', $path.'crpytoj.jar', 'EncryptURLParams', 'soource=BAClubs&identifier=123456&timestamp=2014-02-21 09:59:37.498'];
$last_line = exec(implode(' ', $command), $output, $retval);
print $last_line . "\n";
print $retval . "\n";
?>