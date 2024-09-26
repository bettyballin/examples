<?php

namespace YourVendor\YourExtKey;

require_once 'vendor/autoload.php';

use TYPO3\CMS\Core\Utility\GeneralUtility;
use TYPO3\CMS\Saltedpasswords\Salt\SaltFactory;

$newPassword = 'yourNewPassword'; // replace with your new password

$beUser = new \YourVendor\YourExtKey\Domain\Model\BackendUser();
$saltFactory = SaltFactory::getSaltingInstance('', 'BE');
$beUser->setPassword($saltFactory->getHashedPassword($newPassword));

?>