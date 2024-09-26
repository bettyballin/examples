cpp
#include <QByteArray>
#include <QCryptographicHash>
#include <cassert>

static const int kHexSealSize = 2+64; // hex SHA-256
static QByteArray kSecret = "Things taste bad without salt.";

QByteArray sealHash(const QByteArray &data, int size = -1) {
  if (size < 0) size = data.size();
  QCryptographicHash hash(QCryptographicHash::Sha256);
  hash.addData(data.constData(), size);
  hash.addData(kSecret);
  auto seal = QByteArray("\r\n") + hash.result().toHex();
  Q_ASSERT(seal.size() == kHexSealSize);
  return seal;
}

QByteArray seal(const QByteArray &data) {
  return data + sealHash(data);
}

bool checkSeal(const QByteArray &data) {
  if (data.size() < kHexSealSize) return false;
  auto hexSrc = data.right(kHexSealSize);
  auto hexCmp = sealHash(data, data.size() - kHexSealSize);
  return hexSrc == hexCmp;
}

int main() {
  QByteArray data = "Hello, World!";
  QByteArray sealedData = seal(data);
  bool isValid = checkSeal(sealedData);
  return isValid ? 0 : 1;
}