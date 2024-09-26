import keyring
import getpass
import config

service_name = "MyService"
username = config.ServiceAccount["Username"]
password = getpass.getpass("Enter the service account password: ")

# Store credentials in system's secure storage (e.g Keychain on macOS)
keyring.set_password(service_name, username, password)