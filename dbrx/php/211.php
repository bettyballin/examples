<?php
// Sanitize user input
$sanitized_pattern = wp_kses( $_POST['custom_exclude_pattern'], array(
    'div' => array() ) );

// Store in DB using $wpdb->update or $wpdb->insert
global $wpdb;
$table_name = $wpdb->prefix . 'your_table_name';
if (isset($_POST['custom_exclude_pattern'])) {
    $wpdb->update($table_name, array('custom_exclude_pattern' => $sanitized_pattern), array('id' => 1));
} else {
    $wpdb->insert($table_name, array('custom_exclude_pattern' => $sanitized_pattern));
}

// Display on settings page
echo '<input type="text" name="custom_exclude_pattern" value="' . esc_textarea( $sanitized_pattern ) . '" size="30">';
?>