// app/Http/Middleware/CheckRecordingAccess.php

namespace App\Http\Middleware;

use Closure;
use App\Models\RecordingsTable; // assuming this is the correct namespace for your model
use Illuminate\Support\Facades\Auth;

public function handle($request, Closure $next)
{
    // Get the current user and requested recording
    $user = Auth::user();
    $recordingId = (int)$request->route('id');

    if (!$user || !RecordingsTable::where([
        'RecordID' => $recordingId,
        'User_id'  => $user->id
    ])->exists()) {

        // If the user doesn't have access to this recording
        abort(403);
    }

    return $next($request);
}