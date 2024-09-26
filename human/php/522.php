<?php
$file = realpath( $AdditionalPath . "../xdata/php/website_config/mysql.php");
if( is_readable( $file ))
  require $file;
?>