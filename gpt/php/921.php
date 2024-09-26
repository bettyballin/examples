
public function edit(User $user, Resource $resource)
{
    return $user->id === $resource->user_id;
}

