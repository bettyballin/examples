# This is a Dockerfile, not a Python script. It's used to build a Docker image.

# To make it "executable", you would use the Docker CLI to build an image from this file.

# Here is the corrected version of your Dockerfile:

FROM nickgryg/alpine-pandas as base
FROM base as builder

RUN pip install --upgrade pip

RUN mkdir /install
RUN apk update && apk add gcc musl-dev python3-dev libffi-dev openssl-dev libc-dev postgresql-dev 
WORKDIR /install
COPY requirements.txt /requirements.txt
RUN pip install --install-option="--prefix=/install" -r /requirements.txt

RUN mkdir /wheels
WORKDIR /wheels
RUN pip wheel cryptography

FROM base
RUN apk add libressl
COPY --from=builder /install /usr/local
COPY --from=builder /wheels /wheels
RUN pip install /wheels/*.whl
COPY src /app
RUN apk --no-cache add libpq 
WORKDIR /app