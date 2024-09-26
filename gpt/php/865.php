
class BankAccount {
    public $balance;
    
    public function deposit($amount) {
        if ($amount > 0) {
            $this->balance += $amount;
        }
    }

    public function withdraw($amount) {
        if ($amount > 0 && $this->balance >= $amount) {
            $this->balance -= $amount;
        }
    }
}

$account = new BankAccount();
$account->balance = -1000; // This should not be possible

