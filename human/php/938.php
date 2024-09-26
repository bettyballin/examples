<?php

interface Owneable {
    public function getOwnerId();
}

trait Owned {

    /**
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumn(name="owner_id", referencedColumnName="id")
     */ 
    protected $ownerId;

    public function getOwnerId() {
        return $this->ownerId;
    }

    public function setOwnerId($id) {
        $this->ownerId = $id;
    }
}

class Post implements Owneable {
   use Owned;
}

class Comment implements Owneable {
   use Owned;
}

interface VoterInterface {
    const ACCESS_GRANTED = 1;
    const ACCESS_ABSTAIN = 0;
    const ACCESS_DENIED = -1;

    public function supportsAttribute($attribute);
    public function supportsClass($class);
    public function vote(TokenInterface $token, $object, array $attributes);
}

interface TokenInterface {
    public function getUser();
}

interface UserInterface {
    public function getId();
}

class OwnedVoter implements VoterInterface
{

    public function supportsAttribute($attribute)
    {
        return $attribute === 'edit';
    }

    public function supportsClass($class)
    {
        //same as return is_subclass_of($class, 'Owneable');
        $interfaces = class_implements($class);
        return in_array('Owneable' , $interfaces);
    }

    public function vote(TokenInterface $token, $ownedObject, array $attributes)
    {
        if (!$this->supportsClass(get_class($ownedObject))) {
            return VoterInterface::ACCESS_ABSTAIN;
        }


        if (!$this->supportsAttribute($attributes[0])) {
            return VoterInterface::ACCESS_ABSTAIN;
        }


        $user = $token->getUser();
        if (!$user instanceof UserInterface) {
            return VoterInterface::ACCESS_DENIED;
        }




        $userOwnsObject = $user->getId() === $ownedObject->getOwnerId();
        if ($userOwnsObject) {
            return VoterInterface::ACCESS_GRANTED;
        }


        return VoterInterface::ACCESS_DENIED;
    }
}

// Example usage
$user = new class implements UserInterface {
    public function getId() {
        return 1;
    }
};

$token = new class implements TokenInterface {
    public function getUser() {
        return $user;
    }
};

$post = new Post();
$post->setOwnerId(1);

$voter = new OwnedVoter();
echo $voter->vote($token, $post, ['edit']) . "\n"; // Should print 1 (ACCESS_GRANTED)

$comment = new Comment();
$comment->setOwnerId(2);

echo $voter->vote($token, $comment, ['edit']) . "\n"; // Should print -1 (ACCESS_DENIED)