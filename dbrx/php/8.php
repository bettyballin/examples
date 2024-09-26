protected function _check_my_credential()
{
  $user = sfContext::getInstance()->getUser();
  
  // Check for non-null 'type' property of current logged in user.
  if ($user->getAttribute('sf_guard_user') !== null && 
      $user->getAttribute('sf_guard_user') instanceof sfGuardSecurityUser && 
      !is_null($user->getGuardUser()->getType()))
  {
    return true;
  }
  return false;
}