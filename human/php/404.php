<?php
$_POST = sanitize($_POST);
$_GET = sanitize($_GET);

function sanitize($input) {
    if (is_array($input)) {
        $output = array();
        foreach($input as $var=>$val) {
            $output[$var] = sanitize($val);
        }
    } else {
        if (get_magic_quotes_gpc()) {
            $input = stripslashes($input);
        }
        $output = mysql_real_escape_string($input);
    }
    return $output;
}
?>