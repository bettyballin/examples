import hmac

hashstr = "your_hash_string"
challenge = "your_challenge_string"

hmac1 = hmac.new(hashstr.encode(), challenge.encode(), 'sha1')