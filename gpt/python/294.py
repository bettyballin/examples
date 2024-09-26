
from cryptography.fernet import Fernet

entry1 = "First_sentence"
entry2 = "Second_sentence"
entry3 = "Third_sentence"

##--- Key creation
firstKey = Fernet.generate_key()
with open('.\\TEST\\key.key', 'wb') as
