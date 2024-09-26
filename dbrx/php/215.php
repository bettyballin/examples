use Illuminate\Support\Facades\Gate;

Gate::define('update', 'App\Policies\UserPolicy@updateUserPolicy');