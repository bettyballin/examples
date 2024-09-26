
define('GROUP_ADMIN', 2);
define('GROUP_MODERATOR', 3);
define('GROUP_PROCESS_ORDERS', 4);

$userGroupId = $this->data['user']['group_id'];

switch ($userGroupId) {
    case GROUP_ADMIN:
        // Show buttons to delete records (only admin can do this)
        // Fall through to show a list of records because admin can do everything a moderator or process orders group can do.
    case GROUP_MODERATOR:
    case GROUP_PROCESS_ORDERS:
        // Show a list of records
        break;
    default:
        // User group doesn't have permission to do any of these tasks
        break;
}

// Or, if you prefer using an if statement with group level hierarchy in mind:
if ($userGroupId <= GROUP_PROCESS_ORDERS) {
    // Show a list of records

    if ($userGroupId == GROUP_ADMIN) {
        // Show buttons to delete records (only admin can do this)
    }
}
