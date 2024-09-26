public function updateUserPolicy(User $authenticatedUser, User $user)
{
    return $authenticatedUser->id === $user->id || $authenticatedUser->hasRole('admin');
}