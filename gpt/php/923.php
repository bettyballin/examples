
public function edit($id)
{
    $resource = Resource::findOrFail($id);
    $this->authorize
