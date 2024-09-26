use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\URL;

Route::get('/posts/edit/{post}', [PostController::class, 'edit'])->name('posts.edit');
Route::put('/posts/update/{signed_post}', [PostController::class, 'update'])->name('posts.update');

if (!function_exists('sign_route')) {
    function sign_route($name, ...$parameters)
    {
        return URL::signedRoute($name, $parameters);
    }
}