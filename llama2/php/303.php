public function edit(Resource $resource)
{
    // Check if the authenticated user owns the resource
    if ($resource->user_id !== auth()->user()->id) {
        return redirect()->route('home');
    }

    // Render the edit view
    return view('resources.edit', compact('resource'));
}