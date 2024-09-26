<?php

interface User {
    /**
     * Combines the permissions of the several roles
     * of the user and returns the result.
     * @return Permission */
    function getPermission($key);
}

interface Role {
    /** @return Permission */
    function getPermission($key);
}

interface Permission {
    /** @return Permission */
    function combine(array $permissions);
    /** @return bool */
    function canEdit();
    function canRead();
}

class PermissionImpl implements Permission {
    private $canEdit;
    private $canRead;

    public function __construct($canEdit, $canRead) {
        $this->canEdit = $canEdit;
        $this->canRead = $canRead;
    }

    public function combine(array $permissions) {
        $canEdit = false;
        $canRead = false;
        foreach ($permissions as $permission) {
            $canEdit = $canEdit || $permission->canEdit();
            $canRead = $canRead || $permission->canRead();
        }
        return new PermissionImpl($canEdit, $canRead);
    }

    public function canEdit() {
        return $this->canEdit;
    }

    public function canRead() {
        return $this->canRead;
    }
}

class RoleImpl implements Role {
    private $permissions;

    public function __construct(array $permissions) {
        $this->permissions = $permissions;
    }

    public function getPermission($key) {
        if (isset($this->permissions[$key])) {
            return $this->permissions[$key];
        } else {
            return new PermissionImpl(false, false);
        }
    }
}

class UserImpl implements User {
    private $roles;

    public function __construct(array $roles) {
        $this->roles = $roles;
    }

    public function getPermission($key) {
        $permissions = array();
        foreach ($this->roles as $role) {
            $permissions[] = $role->getPermission($key);
        }
        $permission = new PermissionImpl(false, false);
        return $permission->combine($permissions);
    }
}

$editPermission = new PermissionImpl(true, true);
$readPermission = new PermissionImpl(false, true);

$adminRole = new RoleImpl(array('post' => $editPermission, 'user' => $readPermission));
$moderatorRole = new RoleImpl(array('post' => $readPermission, 'user' => $readPermission));

$user = new UserImpl(array($adminRole, $moderatorRole));

$permission = $user->getPermission('post');
var_dump($permission->canEdit()); // bool(true)
var_dump($permission->canRead()); // bool(true)

?>