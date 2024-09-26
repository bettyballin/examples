$digest = unpack('C*', $digest);
foreach ($digest as $b) {
    printf("%02x", $b);
}
print("\n");