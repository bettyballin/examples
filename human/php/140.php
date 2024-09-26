<?php

class Permission {
    private $canWrite;

    public function __construct($canWrite) {
        $this->canWrite = $canWrite;
    }

    public function canWrite() {
        return $this->canWrite;
    }
}

class User {
    private $permissions;

    public function __construct($permissions) {
        $this->permissions = $permissions;
    }

    public function getPermission($permissionName) {
        return $this->permissions[$permissionName];
    }
}

class UserFactory {
    public static function loadCurrentUser() {
        $permissions = [
            'admin_page' => new Permission(true),
        ];

        return new User($permissions);
    }
}

$u = UserFactory::loadCurrentUser();
if ($u->getPermission('admin_page')->canWrite()) {
    echo "You have write permission on the admin page.";
} else {
    echo "You do not have write permission on the admin page.";
}