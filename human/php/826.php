<?php
if ($_SERVER['REMOTE_ADDR'] != 'your_ip') {
    echo 'Sorry this area is under updates.<br /> <b>We may be down for a week or 2</b><br />';
    die('We are sorry but we are going have to stop you there!<br /><a href="http://google.com/">A link to Google.</a>');
}
?>