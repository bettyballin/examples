// In your controller

use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\File;
use Illuminate\Support\Facades\Response;

public function downloadVideo($videoId)
{
    $user = Auth::user();
    
    if (!$user) {
        abort(403, 'Unauthorized action.');
    }

    // Get video file path based on the given ID.
    $filePath = storage_path('app/videos/' . $videoId);

    if (!File::exists($filePath)) {
        abort(404);
    }

    return response()->download(
        $filePath,
        basename($filePath),
        ['Content-Type' => 'application/octet-stream']
    );
}