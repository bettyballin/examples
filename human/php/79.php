<?php
$ID = "2";
$user = new WP_User($ID);
if (isset($user->wp_capabilities['administrator']) && $user->wp_capabilities['administrator'] == 1) {
    // code here
}
?>