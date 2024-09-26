<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class LitterController extends Controller
{
    public function editLitter(Request $request)
    {
        $litters = // retrieve litters collection

        if ($litters->first()->user_id === Auth::id()) {
            return $this->authorize('edit-litter');
        }

        return response('Unauthorized.', 403);
    }

    public function deletePost(Request $request)
    {
        $post = // retrieve post instance

        $authorized = $request->user()->can('delete', $post);

        return response($authorized ? 'Authorized.' : 'Unauthorized.', $authorized ? 200 : 403);
    }
}



// routes/web.php

Route::get('/edit-litter', 'LitterController@editLitter');
Route::get('/delete-post', 'LitterController@deletePost');



// app/Policies/LitterPolicy.php

namespace App\Policies;

use App\Models\Litter;
use App\Models\User;
use Illuminate\Auth\Access\HandlesAuthorization;

class LitterPolicy
{
    use HandlesAuthorization;

    public function editLitter(User $user, Litter $litter)
    {
        return $litter->user_id === $user->id;
    }
}



// app/Policies/PostPolicy.php

namespace App\Policies;

use App\Models\Post;
use App\Models\User;
use Illuminate\Auth\Access\HandlesAuthorization;

class PostPolicy
{
    use HandlesAuthorization;

    public function delete(User $user, Post $post)
    {
        // define the delete post policy logic here
    }
}