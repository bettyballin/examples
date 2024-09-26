
$referrals = auth::user()->referrals->map(function ($referral) {
    return [
        'name' => $referral->name,
        // any other safe, non-sensitive data you want to include
    ];
});

$host = request()->getHost();
$Link = $host.'?ref='.\Hashids::encode(auth()->user()->
