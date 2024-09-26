import os
from dotenv import load_dotenv

load_dotenv()  # take environment variables from .env.

db_user = os.getenv("DB_USER")
db_password = os.getenv("DB_PASSWORD")