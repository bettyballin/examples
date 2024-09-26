from itsdangerous import TimedSerializer

def test_timed_serializer():
    s = TimedSerializer('sekrit')
    token = s.dumps({'id': 'foobar'})
    print(token)
    print(s.loads(token, max_age=3600))
    try:
        print(s.loads(token, max_age=0))
    except Exception as e:
        print(e)

if __name__ == "__main__":
    test_timed_serializer()