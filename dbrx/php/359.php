$filteredReferrals = $referrals->map(function ($user) {
    return collect($user)->only(['id', 'name']);
});

return view('dashboard', compact('users', 'Link'))->with('referrals', $filteredReferrals);