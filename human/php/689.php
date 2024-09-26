<?php

$file = 'path_to_your_file.php'; // replace with your file path

// change ownership to current user
chown($file, get_current_user());

// change group to webserver (e.g. www-data, apache, httpd)
chgrp($file, 'www-data'); // replace with your webserver group

// change permissions to 640 (owner: read+write, group: read, others: none)
chmod($file, 0640);

?>