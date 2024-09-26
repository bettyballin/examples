<?php
$username = isset($_POST['username']) ? filter_var($_POST['username'], FILTER_SANITIZE_STRING) : '';

or (if you insist on using the old mysql_ functions, which is not recommended)


<?php
$username = isset($_POST['username']) ? mysql_real_escape_string($_POST['username']) : '';