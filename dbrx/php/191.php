use Illuminate\Http\Request;
use App\Models\Post;

public function edit(Post $post)
{
    return view('posts.edit', compact('post'));
}

public function update(Request $request, Post $signed_post)
{
    if (!hash_equals((string) $request->route('id'), (string) $signed_post->getKey())) {
        abort(403);
    }

    // Validate and process your form data here

    return redirect()->back();
}