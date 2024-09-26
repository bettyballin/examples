class User {
    public $id;
}

class Resource {
    public $user_id;
}

class Policy {
    public function update(User $user, Resource $resource)
    {
        return $user->id == $resource->user_id; //for example
    }
}

$user = new User();
$user->id = 1;

$resource = new Resource();
$resource->user_id = 1;

$policy = new Policy();
var_dump($policy->update($user, $resource));