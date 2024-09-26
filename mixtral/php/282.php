class User implements AdvancedUserInterface
{
    // ...

    /**
     * @ORM\ManyToMany(targetEntity="Role")
     */
    private $roles;

    public function getRoles()
    {
        return array_map('strtoupper', $this->roles->toArray());
    }

    // ...
}