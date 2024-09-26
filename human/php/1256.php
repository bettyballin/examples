<?php

namespace YourVendor\YourExtKey\Controller;

use TYPO3\CMS\Core\Utility\GeneralUtility;
use YourVendor\YourExtKey\Domain\Repository\BackendUserRepository;

class YourController extends ActionController
{
    /**
     * beUserRepository
     *
     * @var \YourVendor\YourExtKey\Domain\Repository\BackendUserRepository
     * @inject
     */
    protected $beUserRepository;

    public function __construct(BackendUserRepository $beUserRepository)
    {
        $this->beUserRepository = $beUserRepository;
    }
}