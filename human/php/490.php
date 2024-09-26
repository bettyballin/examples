<?php
foreach($_POST as $name => &$value)
{
    $value = preg_replace( "/[<>#$%]/", "", $value);
    $value = preg_replace('/\s\s+/', ' ', $value);
}
?>