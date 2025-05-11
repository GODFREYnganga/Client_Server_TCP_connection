# Client_Server_TCP_connection


# Java TCP Client-Server Communication

This project demonstrates a basic TCP client-server communication model in Java using `Socket` and `ServerSocket` classes. It shows how two applications (client and server) can exchange messages over a TCP connection.

## How It Works

### Server
- The server listens on a specific port (e.g. `5054`) for incoming client connections.
- When a client connects, the server accepts the connection and waits to receive a message.
- The server may then respond with a predefined reply or echo the client's message back.
- The server can handle a single client in this basic setup.

### Client
- The client connects to the server using the server's IP address (typically `localhost` for local testing) and the port number.
- It sends a message to the server and waits for a response.
- After receiving the response, it displays it and then closes the connection.

## Key Java Classes Used
- `ServerSocket` — to create the server socket and listen for incoming connections.
- `Socket` — used both on client and server sides to establish and manage the connection.
- `InputStreamReader` and `BufferedReader` — for reading text input from the socket.
- `PrintWriter` — for sending text output through the socket.

## How to Run

1. **Compile both files:**
   ```bash
   javac TCP_Server.java
   javac TCP_Client.java
