
// src/Security/UserChecker.php

namespace App\Security;

use Symfony\Component\Security\Core\User\UserChecker as BaseUserChecker;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Security\Core\Exception\AccountStatusException;

class UserChecker extends BaseUserChecker
{
    public function checkPreAuth(UserInterface $user)
    {
        // Call the parent to maintain the existing checks
        parent::checkPreAuth($user);
    }

    public function checkPostAuth(UserInterface $user)
    {
        // Don't call the parent to bypass the session invalidation on role change
    }
}

