
import hashlib

def commutative_hash(int1, str1, int2, str2):
    # Use a cryptographic hash function for the strings
    str1_hash = int(hashlib.sha256(str1.encode('utf-8')).hexdigest(), 16)
    str2_hash = int(hashlib.sha256(str2.encode('utf-8')).hexdigest(), 16)
    
    # Combine the hashes in a commutative way
    combined_hash = int1 ^ str1_hash ^ int2 ^ str2_hash
    
    #
