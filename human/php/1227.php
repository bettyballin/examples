<?php

namespace AppBundle\Configuration;

/**
 * @Annotation
 */
class Security extends \Sensio\Bundle\FrameworkExtraBundle\Configuration\Security
{
    public function getAliasName()
    {
        return 'app_security';
    }

    public function allowArray()
    {
        // allow nested configuration (class/method).
        return true;
    }
}