namespace App\Policies;

use App\Models\User;
use Illuminate\Support\Facades\Storage;

class StoragePolicy
{
    public function view(User $user)
    {
        // Only allow authenticated users to access the storage directory
        return $user->authenticated();
    }
}