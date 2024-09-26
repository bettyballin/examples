$allowed_values = ['interest', 'other-value'];
if (isset($_GET['display']) && in_array($_GET['display'], $allowed_values)) {
    // ...
}