<?php

use Drupal\user\Entity\User;

$uid = 1; // Replace with the desired user ID
$account = User::load($uid);
if ($account && $account->hasRole('moderator')) {
  // Reveal editable links.
  echo "User $uid is a moderator.";
} else {
  echo "User $uid is not a moderator.";
}