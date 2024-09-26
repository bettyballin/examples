import unittest
from charm.toolbox.pairinggroup import PairingGroup, GT
from charm.toolbox.symcrypto import SymmetricCryptoAbstraction
from hashlib import sha1

class SymmetricCryptoAbstractionTest(unittest.TestCase):

    def testAESCBC(self):
        self.MsgtestAESCBC(b"hello world")

    def testAESCBCLong(self):
        self.MsgtestAESCBC(b"Lots of people working in cryptography have no deep \
   concern with real application issues. They are trying to discover things \
    clever enough to write papers about -- Whitfield Diffie.")

    def testAESCBC_Seperate(self):
        self.MsgTestAESCBCSeperate(b"Lots of people working in cryptography have no deep \
    concern with real application issues. They are trying to discover things \
    clever enough to write papers about -- Whitfield Diffie.")

    def MsgtestAESCBC(self,msg):
        groupObj = PairingGroup('SS512')
        a =  SymmetricCryptoAbstraction(sha1(groupObj.random(GT)).digest())
        ct = a.encrypt(msg)
        dmsg = a.decrypt(ct);
        assert msg == dmsg , 'o: =&gt;%s\nm: =&gt;%s' % (msg, dmsg)

    def MsgTestAESCBCSeperate(self,msg):
        groupObj = PairingGroup('SS512')
        ran = groupObj.random(GT)
        a =  SymmetricCryptoAbstraction(sha1(ran).digest())
        ct = a.encrypt(msg)        
        b =  SymmetricCryptoAbstraction(sha1(ran).digest())
        dmsg = b.decrypt(ct);
        assert msg == dmsg , 'o: =&gt;%s\nm: =&gt;%s' % (msg, dmsg)

if __name__ == '__main__':
    unittest.main()