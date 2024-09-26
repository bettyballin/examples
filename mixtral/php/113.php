<?php
if (get_magic_quotes_gpc()) {
    function stripslashes_deep($value)
    {
        $value = is_array($value) ?
                 array_map('stripslashes_deep', $value) :
                 stripslashes($value);

        return $value;
    }

    $_POST = stripslashes_deep($_POST);
}
?>