
use Cake\Auth\DefaultPasswordHasher;

// Inside your UsersTable class
public function beforeSave(Event $event, EntityInterface $entity, ArrayObject $options)
{
    if ($entity->isDirty('password')) {
        $hasher = new DefaultPasswordHasher();
        $entity->password = $hasher->hash($entity->password);
    }
    return true;
}

