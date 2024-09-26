php
<?php
$sql = $wpdb->prepare( 'SELECT * FROM table WHERE column = %s', 'value' );
?>