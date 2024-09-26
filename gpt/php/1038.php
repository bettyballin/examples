
public function handle($request, Closure $next, $ability, $model)
{
    try {
        // Check if the user has the permission
        if ($request->user()->can($ability, $model)) {
            return $next($request);
        }

        // If not, throw an AuthorizationException
        throw new \Illuminate\Auth\Access\AuthorizationException;
    } catch (\Illuminate\Database\Eloquent\ModelNotFoundException $e) {
        // If a model is not found, catch
