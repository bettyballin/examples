from asn1crypto import cms
import datetime
import time

class CustomError(Exception):
    pass

def cms_compare(p7: bytes) -> None:
    ci = cms.ContentInfo.load(p7)
    try:
        content = dict(ci.native['content'])
        signed_time: str = dict(dict(content['signer_infos'][0])['signed_attrs'][1])['values'][0]
        timed: datetime = datetime.datetime.strptime(str(signed_time), "%Y-%m-%d %H:%M:%S%z")

        if int(time.time()) - int(timed.timestamp()) > 30:
            raise CustomError('error')
    except TypeError:
        raise CustomError('error')