// app/Policies/LitterPolicy.php
namespace App\Policies;

use App\Models\User;
use App\Models\Litter;
use Illuminate\Auth\Access\HandlesAuthorization;

class LitterPolicy
{
    use HandlesAuthorization;

    public function edit(User $user, Litter $litter)
    {
        return $user->id === $litter->user_id;
    }
}

// app/Providers/AuthServiceProvider.php
namespace App\Providers;

use Illuminate\Foundation\Support\Providers\AuthServiceProvider as ServiceProvider;
use Illuminate\Support\Facades\Gate;

class AuthServiceProvider extends ServiceProvider
{
    protected $policies = [
        // ...
        App\Models\Litter::class => App\Policies\LitterPolicy::class,
    ];

    public function boot()
    {
        $this->registerPolicies();
    }
}