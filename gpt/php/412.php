
function mymodule_menu_alter(&$items) {
  // Check if the menu item for viewing nodes exists
  if (isset($items['node/%node'])) {
    // Override the access callback for node view pages
    $items['node/%node']['access callback'] = 'mymodule_custom_access_callback';
    // Pass the original node object as an argument to the callback
    $items['node/%node']['access arguments'] = array(1);
  }
}

function mymodule_custom_access_callback($node) {
  global $user;

  // Load the full node object if it's not already loaded
  if (!is_object($
