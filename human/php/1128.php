<?php

function pa_custom_rules() {
    add_rewrite_rule('listing/(.*)$', 'index.php?pagename=listing&action=$matches[1]', 'top');
    add_rewrite_tag('%action%', '(.*)');
}

add_action('init', 'pa_custom_rules');

?>