<?php

use Sensio\Bundle\FrameworkExtraBundle\Configuration\Security;

/**
 * @Security("is_granted('ROLE_ADMIN') or is_granted('ROLE_RESPONSIBLE')")
 */
class MyClass
{
    // your code here
}