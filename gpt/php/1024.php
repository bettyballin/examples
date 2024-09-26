
   use Illuminate\Support\Facades\Log;

   Log::channel('security')->info('Suspicious activity detected', [
       'ip' => request()->ip(),
       'user_agent' => request()->header('User-Agent'),
       'input' => request()->all(),
       // ... Any additional relevant data
   ]);
   
