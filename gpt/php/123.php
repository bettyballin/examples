
// $userId is the ID of the currently logged-in user
// $access_type is determined based on the user's permissions
$access_type = user_has_permission($userId, 'edit_username') ? 'edit' : 'readonly';

