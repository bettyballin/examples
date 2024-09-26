
// src/Entity/Role.php

/**
 * @ORM\Table(name="roles")
 * @ORM\Entity()
 */
class Role
{
    // ...

    /**
     * @ORM\ManyToMany(targetEntity="User", mappedBy="roles")
     */
    private $users;

    /**
     * @ORM\ManyToMany(targetEntity="Permission", inversed
