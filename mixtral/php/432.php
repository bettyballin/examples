class User {
    private $email;
    private $usernameLowercase;

    public function setEmail($email): void
    {
        $this->email = $email;
    }

    public function setUsername($username): void
    {
        $this->setEmail($username);

        // Set username_lowercase
        if ($username !== null && is_string($username)) {
            $this->usernameLowercase = strtolower(trim($username));
        }
    }
}

$user = new User();
$user->setUsername('JohnDoe');