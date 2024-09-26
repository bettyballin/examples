<?php
function add_custom_cap() {
    $cap = array(
        'name' => __('Manage extra user field', 'textdomain'),
        'slug' => 'manage-extra-field',
        'description' => __('Ability to manage the extra user field', 'textdomain'),
        'capabilities' => array(
            'edit_user_fields' => true
        )
    );
    add_cap($cap);
}
add_action('admin_init', 'add_custom_cap');
?>