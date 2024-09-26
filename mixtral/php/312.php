<?php

$data = [
    'tx_extbase_type' => '\\TYPO3\\CMS\\Extbase\\DomainObject\\AbstractEntity',
    '_ORIG_uid'       => $beUser->getUid(),
    'password'        => md5('your-desired-password')
];

$dataHandler = \TYPO3\CMS\Core\Utility\GeneralUtility::makeInstance(\TYPO3\CMS\Core\DataHandling\DataHandler::class);

// Add the data to be processed
$dataHandler->start([$data], 'be_users');

// Process and store
$dataHandler->process_cmdmap();