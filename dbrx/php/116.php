function wp_menu_force_https($menu_item) {
    if (strpos($menu_item->url, 'http://') === 0) {
        $menu_item->url = str_replace('http://', 'https://', $menu_item->url);
    }
    return $menu_item;
}
add_filter('wp_nav_menu_objects', 'wp_menu_force_https');