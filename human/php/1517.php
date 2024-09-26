use Illuminate\Support\Facades\Passport;
use App\Models\PassportClient;

public function boot()
{
    // ...

    Passport::useClientModel(PassportClient::class);
}