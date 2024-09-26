import os
import hashlib
from passlib.hash import Argon2
from limiter import RateLimiter

if __name__ == "__main__":
    # usage example
    argon2 = Argon2()

    password = "mysecretpassword"
    hashed_password = argon2.hash(password)
    print(f"Hashed Password: {hashed_password}")

    # verify password
    is_valid = argon2.verify(password, hashed_password)
    print(f"Is Valid: {is_valid}")

    # example rate limiting usage
    limiter = RateLimiter()
    limiter.limit(key="test", tries=3, period=60)