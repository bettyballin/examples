use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * @ORM\Entity
 */
class User
{
    /**
     * @ORM\Column(name="userpass", type="string", length=100, nullable=false)
     * @Assert\NotBlank(message="Password may not be empty")
     * @Assert\Length(
     *      min = "5",
     *      max = "12",
     *      minMessage = "Password must be at least 5 characters long",
     *      maxMessage = "Password cannot be longer than than 12 characters",
     *      groups = {"Default"}
     * )
     */
    private $password;

    public function getPassword()
    {
        return $this->password;
    }

    public function setPassword($password)
    {
        $this->password = $password;
    }
}