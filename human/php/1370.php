<?php
$source='http://jumanjipets.co.uk/wp-content/uploads/2018/02/koi.jpg';
$contents=file_get_contents( $source );

printf( "<img src='data:image/jpeg;base64, %s' />", base64_encode( $contents ) );
?>