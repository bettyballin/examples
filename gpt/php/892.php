
use TYPO3\CMS\Core\DataHandling\DataHandler;
use TYPO3\CMS\Core\Utility\GeneralUtility;
use TYPO3\CMS\Saltedpasswords\Utility\SaltedPasswordsUtility;

// ...

$beUserArray = [];
$beUserArray['be_users']['NEW']['username'] = $username;
$beUserArray['be_users']['NEW']['email'] = $email;
$beUserArray['be_users']['NEW']['realName'] = $realname;
$beUserArray['be_users']['NEW']['password'] = SaltedPasswordsUtility::getHashedPassword($password);

/** @var DataHandler $dataHandler */
$dataHandler = GeneralUtility::makeInstance
