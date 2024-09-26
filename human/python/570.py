from fastapi import Depends, HTTPException, status
from fastapi.security import OAuth2PasswordBearer
from pydantic import BaseModel
from datetime import datetime
import jwt

# Define constants
SECRET_KEY = "your_secret_key_here"
ALGORITHM = "your_algorithm_here"

# Define OAuth2 scheme
oauth2_scheme = OAuth2PasswordBearer(tokenUrl="token")

# Define TokenData model
class TokenData(BaseModel):
    username: str
    expires: datetime

# Define Users model (assuming it's a SQLAlchemy model)
from sqlalchemy import Column, String
from sqlalchemy.ext.declarative import declarative_base

Base = declarative_base()

class Users(Base):
    __tablename__ = "users"
    name = Column(String, primary_key=True)

    @classmethod
    def search(cls, where):
        # implement your search logic here
        pass

# Define router
from fastapi import APIRouter
router = APIRouter()

@router.get('/user/me')
async def get_current_user(token: str = Depends(oauth2_scheme)):
    # get the current user from auth token

    # define credential exception
    credentials_exception = HTTPException(
        status_code=status.HTTP_401_UNAUTHORIZED,
        detail="Could not validate credentials",
        headers={"WWW-Authenticate": "Bearer"},
    )

    try:
        # decode token and extract username and expires data
        payload = jwt.decode(token, SECRET_KEY, algorithms=[ALGORITHM])
        username: str = payload.get("sub")
        expires = payload.get("exp")
    except jwt.JWTPayloadError:
        raise credentials_exception

    # validate username
    if username is None:
        raise credentials_exception
    token_data = TokenData(username=username, expires=datetime.fromtimestamp(expires))
    user = Users.search(where('name') == token_data.username)
    if user is None:
        raise credentials_exception

    # check token expiration
    if expires is None:
        raise credentials_exception
    if datetime.utcnow() > token_data.expires:
        raise credentials_exception
    return user