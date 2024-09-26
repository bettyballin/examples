<?php
/**
 * Implementation of hook_nodeapi().
 */
function MODULE_nodeapi(&$node, $op, $a3 = NULL, $a4 = NULL) {
  global $user;

  switch ($op) {
    case 'view':
      if ($node->type == 'CONTENT_TYPE' && $user->uid < 1) {
        drupal_access_denied();
        exit;
      }
      break;
  }
}
?>