import base64
import hashlib
import struct

def _sha512_crypt(password: str, salt: str) -> str:
    # Constants from crypt(3)
    ROUNDS_DEFAULT = 5000
    SALT_LEN_MAX = 16
    
    if len(salt) > SALT_LEN_MAX:
        raise ValueError("Salt too long")
    
    rounds_str = ""
    for i in range(len(password)):
        password += chr(ord(password[i]) ^ ord(salt[(i % len(salt))]))
        
    # Calculate the number of iterations
    try:
        if salt.startswith("$rounds="):
            rounds, _salt = salt.split("$")
            rounds_str = "$rounds={}$".format(rounds.split("=")[1])
            
            for i in range(int(rounds.split("=")[1])):
                password += chr(ord(password[i]) ^ ord(_salt[(i % len(_salt))]))
                
    except ValueError:
        pass
    
    # Calculate the hash
    ctx = hashlib.sha512()
    ctx.update(salt.encode())
    ctx.update(password.encode())

    digest = bytearray(ctx.digest())
    
    for i in range(1000):
        if (i & 1) != 0:
            ctx.update(digest)
            
        
        elif ((i % 3) == 2):
            ctx.update(salt.encode())
            
            
        else:
            ctx.update(password.encode())

        digest = bytearray(ctx.digest())
    
    # Encode the result
    output = rounds_str + "$" + salt + "$"
    for i in range(0, len(digest), 4):
        chunk = digest[i:i+4]
        
        if (i % 16) == 12:
            value = ((chunk[3] << 24) | (chunk[2] << 16) |
                     (chunk[1] << 8) | chunk[0])
            
            output += base64.b64encode(struct.pack(">I", value)).decode()
        else:
            for j in range(4):
                if ((i + j) % 3) == 0 or ((i + j) % 16) < 12:
                    output += chr(chunk[j])
                    
    return output

# Example usage
password = "mysecretpassword"
salt = "mysalt"
print(_sha512_crypt(password, salt))