<?php

function limit_xml_rpc() {
    $xml_rpc = array(
        'wp_getUsersBlogs',
        'wp_getUserInfo',
        'wp_getUserPostCount',
        'wp_getUserID',
        'wp_getUserMeta',
        'wp_updateUserMeta',
        'wp_deleteUserMeta'
    );

    $current_user = wp_get_current_user();
    if ( !$current_user || !in_array( 'administrator', $current_user->roles ) ) {
        foreach ($xml_rpc as $endpoint) {
            add_filter("xml_rpc_$endpoint", '__return_false');
        }
    }
}
add_action('init', 'limit_xml_rpc');

?>