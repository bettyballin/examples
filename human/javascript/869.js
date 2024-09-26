Here is the executable JavaScript code:


// METADATA BUILDER
import {
  encodeRoute,
  encodeBearerAuthMetadata,
  encodeSimpleAuthMetadata,
  encodeAndAddCustomMetadata,
  encodeAndAddWellKnownMetadata,
  MESSAGE_RSOCKET_ROUTING,
  MESSAGE_RSOCKET_AUTHENTICATION,
} from "rsocket-core";

export class Metadata {
  constructor(json) {
    this.route = json["route"];
    this.auth = json["auth"];
  }

  toMetadata() {
    let metadata = Buffer.alloc(0);
    if (this.auth) {
      if (this.auth["type"] === "bearer") {
        metadata = encodeAndAddCustomMetadata(
          metadata,
          MESSAGE_RSOCKET_AUTHENTICATION.string,
          encodeBearerAuthMetadata(this.auth["token"])
        );
      }
      if (this.auth["type"] === "simple") {
        metadata = encodeAndAddCustomMetadata(
          metadata,
          MESSAGE_RSOCKET_AUTHENTICATION.string,
          encodeSimpleAuthMetadata(this.auth["username"], this.auth["password"])
        );
      }
    }
    if (this.route) {
      metadata = encodeAndAddWellKnownMetadata(
        metadata,
        MESSAGE_RSOCKET_ROUTING,
        encodeRoute(this.route)
      );
    }
    return metadata;
  }
}

// RSOCKET CLIENT CLASS
import RSocketWebSocketClient from "rsocket-websocket-client";
import {
  BufferEncoders,
  MESSAGE_RSOCKET_COMPOSITE_METADATA,
  RSocketClient,
  toBuffer,
} from "rsocket-core";
import Metadata from "./metadata";

export class SpringClient {
  constructor(
    wsUrl,
    keepAlive = 60000,
    lifetime = 180000,
    dataMimeType = "application/json"
  ) {
    this.client = new RSocketClient({
      setup: {
        keepAlive,
        lifetime,
        dataMimeType,
        metadataMimeType: MESSAGE_RSOCKET_COMPOSITE_METADATA.string,
      },
      transport: new RSocketWebSocketClient(
        {
          url: wsUrl,
        },
        BufferEncoders
      ),
    });
  }

  bearerAuth(token) {
    this.auth = { type: "bearer", token };
  }

  simpleAuth(username, password) {
    this.auth = { type: "simple", username, password };
  }

  logout() {
    this.auth = null;
  }

  connect(
    completeCallback = (socket) => {},
    errorCallback = (error) => {},
    subscribeCallback = (cancel) => {}
  ) {
    this.client.connect().subscribe({
      onComplete: (socket) => {
        this.socket = socket;
        completeCallback(socket);
      },
      onError: (error) => {
        errorCallback(error);
      },
      onSubscribe: (cancel) => {
        subscribeCallback(cancel);
      },
    });
  }

  requestResponse(
    data,
    route,
    completeCallback = (data) => {},
    errorCallback = (error) => {},
    subscribeCallback = (cancel) => {}
  ) {
    if (this.socket) {
      const metadata = new Metadata({
        route,
        auth: this.auth,
      }).toMetadata();
      data = toBuffer(data);
      this.socket.requestResponse({
        data,
        metadata,
      }).subscribe({
        onComplete: (data) => {
          completeCallback(data);
        },
        onError: (error) => {
          errorCallback(error);
        },
        onSubscribe: (cancel) => {
          subscribeCallback(cancel);
        },
      });
    }
  }
}

// EXAMPLE, HOW TO USE
import SpringClient from "./springclient";

const client = new SpringClient("ws://localhost:7000/", 5000, 15000, "text/plain");

client.connect(
  (socket) => {
    console.log("got connection complete");
  },
  (error) => {
    console.log("got connection error");
    console.error(error);
  },
  (cancel) => {
    console.log("got connection subscribe");
    /* call cancel() to abort */
  }
);

client.simpleAuth("LOGIN", "PASSWORD");

client.requestResponse("MESSAGE", "ROUTE",
  (data) => {
    console.log("got response with requestResponse");
    console.log(data.data);
  },
  (error) => {
    console.log("got error with requestResponse");
    console.error(error);
  },
  (cancel) => {
    console.log("requestResponse cancel");
    /* call cancel() to stop onComplete/onError */
  }
);


Please ensure to install the required packages by running `npm install rsocket-core rsocket-websocket-client` in your terminal before executing this code.