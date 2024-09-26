<?php

function add_extra_profile_field() {
    $args = array(
        'label' => __('Extra Field', 'textdomain'),
        'desc' => __('This is an extra field for users', 'textdomain'),
        'id' => 'extra_field',
        'type' => 'text'
    );
    add_user_field($args);
}

add_action('admin_init', 'add_extra_profile_field');

function add_user_field($args) {
    // Assuming this function is not defined elsewhere
    // This is a basic implementation
    add_action('show_user_profile', function($user) use ($args) {
        ?>
        <table class="form-table">
            <tr>
                <th><label for="<?php echo $args['id']; ?>"><?php echo $args['label']; ?></label></th>
                <td>
                    <input type="<?php echo $args['type']; ?>" name="<?php echo $args['id']; ?>" id="<?php echo $args['id']; ?>" value="<?php echo get_user_meta($user->ID, $args['id'], true); ?>" class="regular-text" /><br />
                    <span class="description"><?php echo $args['desc']; ?></span>
                </td>
            </tr>
        </table>
        <?php
    });

    add_action('edit_user_profile', function($user) use ($args) {
        ?>
        <table class="form-table">
            <tr>
                <th><label for="<?php echo $args['id']; ?>"><?php echo $args['label']; ?></label></th>
                <td>
                    <input type="<?php echo $args['type']; ?>" name="<?php echo $args['id']; ?>" id="<?php echo $args['id']; ?>" value="<?php echo get_user_meta($user->ID, $args['id'], true); ?>" class="regular-text" /><br />
                    <span class="description"><?php echo $args['desc']; ?></span>
                </td>
            </tr>
        </table>
        <?php
    });

    add_action('personal_options_update', function($user_id) use ($args) {
        if (!current_user_can('edit_user', $user_id)) {
            return false;
        }
        update_user_meta($user_id, $args['id'], $_POST[$args['id']]);
    });

    add_action('edit_user_profile_update', function($user_id) use ($args) {
        if (!current_user_can('edit_user', $user_id)) {
            return false;
        }
        update_user_meta($user_id, $args['id'], $_POST[$args['id']]);
    });
}

?>