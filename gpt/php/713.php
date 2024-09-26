
public function supportsClass($class)
{
    $supportedClasses = array(
        'Project\AgenceBundle\Entity\Agence',
        'Project\AgenceBundle\Entity\SubAgence',
        'Project\AgenceBundle\Entity\Subscription'
    );

    return in_array($class, $supportedClasses) || array_reduce($supportedClasses, function($carry, $supportedClass) use ($class) {
        return $carry || is_subclass_of($class, $supportedClass);
    }, false);
}

