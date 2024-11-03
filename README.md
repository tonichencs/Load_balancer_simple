# Load_balancer_simple
### First iteration:
This version aims to lay the ground for a simple load balancer that allows the selection of the server that has the most avaiable resources to process the request.

#### Requirements:
- Implement a basic Server Class which:
    - Has a counter which measures its current load
    - Has a pseudomethod which takes the request and process, in the synchronous fashion.
- Implement the Load Balancer Class which:
    - Takes in requests on a running base
    - Pick the server with least process going on and forward the request to it.
    - Register servers only, not handling unregistering servers yet.