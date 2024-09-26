
class User extends BaseUser
{
    // ...

    public function save(PropelPDO $con = null)
    {
        // Check if a password has been provided
        if (strlen($this->getPassword()) > 0) {
            // Hash the password before saving
            $this->setPassword(sha1($this->getPassword())); // Use sha1 or another hashing function of your choice
        }
        
        // Call the parent save method to handle the actual saving
        return parent::save($con);
    }

    // ...
}

