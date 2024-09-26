namespace App\Policies;

use App\Models\Resource;
use App\Models\User;
use Illuminate\Auth\Access\HandlesAuthorization;

class ResourcePolicy
{
    use HandlesAuthorization;

    public function view(User $user, Resource $resource)
    {
        return $user->id === $resource->user_id;
    }

    public function edit(User $user, Resource $resource)
    {
        return $this->view($user, $resource);
    }
}