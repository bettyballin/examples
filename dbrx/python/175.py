import os
from dotenv import load_dotenv

load_dotenv()  # take environment variables from .env.

CLIENT_KEY = os.getenv("API_CLIENT_KEY")