protected function supportsClass($class)
{
    $supportedClasses = [
        'AppBundle\Entity\User\Associate',
        // Add other supported classes here
    ];

    return in_array(get_parent_class($class), $supportedClasses);
}