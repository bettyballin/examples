from datetime import datetime, timedelta
from typing import Optional, Dict
import jwt

ACCESS_TOKEN_EXPIRE_MINUTES = 30  # define access token expiration time
SECRET_KEY = "your_secret_key_here"  # define secret key
ALGORITHM = "HS256"  # define algorithm

def create_access_token(data: Dict, expires_delta: Optional[timedelta] = None):
    to_encode = data.copy()
    scopes = []
    for key in ['scopes']:
        if key in data and isinstance(data[key], list) and all(isinstance(item, str) for item in data[key]):
            scopes.extend(data[key])
    expire = datetime.utcnow() + timedelta(minutes=ACCESS_TOKEN_EXPIRE_MINUTES)
    to_encode.update({"exp": expire, "sub": data["username"], "scopes": scopes})
    encoded_jwt = jwt.encode(to_encode, SECRET_KEY, algorithm=ALGORITHM)
    return {"access_token": encoded_jwt, "token_type": "bearer"}