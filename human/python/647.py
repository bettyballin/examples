import os
from dotenv import load_dotenv, find_dotenv

if __name__ == "__main__":
    load_dotenv(find_dotenv()) # Load the .env file.

    # Fetch variables from the .env file.
    account_username = os.getenv("ACCOUNT_USERNAME")
    account_password = os.getenv("ACCOUNT_PASSWORD")

    print(account_username)
    print(account_password)