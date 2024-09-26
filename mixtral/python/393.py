import jwt
from datetime import timedelta
from typing import Optional

SECRET_KEY = "your-secret-key"
ALGORITHM = "your-algorithm"

def create_access_token(data: dict, scope: str = None, expire_delta: Optional[timedelta] = None):
    if scope is not None and len(scope) > 0:
        data["scp"] = [s.strip() for s in scope.split(" ")]

    if expire_delta is not None:
        data["exp"] = (datetime.utcnow() + expire_delta).timestamp()

    encoded_jwt = jwt.encode(data, SECRET_KEY, algorithm=ALGORITHM)

    return encoded_jwt