class User
{
    // ...

    /**
     * @ORM\OneToOne(targetEntity=Info::class, mappedBy="user", fetch="EAGER")
     */
    private $info;

    public function getInfo()
    {
        return $this->info;
    }

    //...
}

// App\Security\AppCustomAuthenticator

public function getUser($credentials, UserProviderInterface $userProvider)
{
   ...

   return new YourOwnAuthenticatedToken(
       $user->getId(),
       $user->getRoles(),
       ['info' => $user->getInfo()]
    );
}