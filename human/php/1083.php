class User {
    private $roles = [];

    public function addRole($role) {
        $this->roles[] = $role;
    }

    public function getRoles() {
        return $this->roles;
    }
}

class UserManager {
    private $user;

    public function getUser() {
        $this->user = new User();
        return $this->user;
    }
}

$manager = new UserManager();
$user = $manager->getUser();
$user->addRole('ROLE_NEWUSER');

print_r($user->getRoles());