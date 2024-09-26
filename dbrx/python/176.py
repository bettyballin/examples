import hvac

client = hvac.Client(url="http://localhost:8200")
client.token = "your-root-token"

secret_path = "/path/to/secret"
secrets = client.secrets.kv.read_secret_version(path=secret_path)

CLIENT_KEY = secrets["data"]["data"]["API_CLIENT_KEY"]