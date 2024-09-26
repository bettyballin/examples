
// In the view, include the CSRF token in the AJAX call:
'ajax' => array(
    'type' => 'POST',
    'url' => $this->createUrl('addPermission'),
    'data' => array
