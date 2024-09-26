cpp
#include <cryptopp/ecp.h>
#include <cryptopp/files.h>
#include <cryptopp/filters.h>

bool ECP::DecodePoint(ECP::Point &P, BufferedTransformation &bt, size_t encodedPointLen) const
{
    byte buf[encodedPointLen];
    bt.Get(buf, encodedPointLen);

    Integer p = GetField().GetModulus();
    word32 pBitLength = p.BitLength();
    word32 pByteLength = (pBitLength + 7) / 8;

    if (encodedPointLen != 1 + 2 * pByteLength)
        return false;

    word32 type = buf[0];
    if (type != 2 && type != 3 && type != 4)
        return false;

    Integer x, y;
    if (type == 4)
    {
        x.Decode(buf + 1, pByteLength);
        y.Decode(buf + 1 + pByteLength, pByteLength);
    }
    else
    {
        x.Decode(buf + 1, pByteLength);

        bool square = (type == 3);
        if (!GetCurve().GetY(x, square, y))
            return false;
    }

    P.x = x;
    P.y = y;
    return true;
}