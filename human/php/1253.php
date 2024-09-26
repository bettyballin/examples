<?php
namespace YourVendor\YourExtKey\Domain\Model;

class BackendUser extends \TYPO3\CMS\Extbase\Domain\Model\BackendUser
{
    /**
     * @var string
     */
    protected $password = '';

    /**
     * Returns the password
     *
     * @return string
     */
    public function getPassword()
    {
        return $this->password;
    }

    /**
     * Sets the password
     *
     * @param string $password
     * @return void
     */
    public function setPassword($password)
    {
        $this->password = (string)$password;
    }
}