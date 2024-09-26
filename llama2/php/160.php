public function supportsClass($class)
{
    if (!in_array($class, array('MyBundle\Entity\Foobar', 'MyOtherBundle\Entity\Bar'))) {
        return false;
    }

    // ...
}