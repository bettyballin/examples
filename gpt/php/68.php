
function custom_user_profile_fields($user) {
    if (current_user_can('administrator')) {
        ?>
        <h3>Extra Profile Information</h3>

        <table class="form-table">
            <tr>
                <th><label for="approved">Approved</label></th>
                <td>
                    <input type="checkbox" name="approved" id="approved" <?php echo (esc_attr(get_the_author_meta('approved', $user->ID)) == 'yes') ? 'checked="checked"' : ''; ?>/>
                    <span class="description">Check if the user is approved.</span>
                </td>
            </tr>
        </table>
        <?php
    }
}
add_action('show_user_profile', 'custom_user_profile_fields');
add_action('edit_user_profile', 'custom_user_profile_fields');

