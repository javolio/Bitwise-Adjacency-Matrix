Bitwise-Adjacency-Matrix
========================

A fairly simple tool for creating directed, unweighted graphs. Edges are stored in a bitwise adjacency matrix, minimizing memory usage. Both the addition and removal of edges are supported. Graphs can have any number of nodes. A good number of user commands are included. This could very easily be connected to a graphical interface of some sort.

Run either "Bitwise Adjacency Matrix.bat" or "Bitwise Adjacency Matrix.sh", depending on your operating system. Alternatively, run "Bitwise Adjacency Matrix.jar" from your command prompt or bash shell.

Available Commands:
* add \<a\> \<b\> - Adds a directed edge from a to b.
* check \<a\> \<b\> - Checks whether a directed edge from a to b exists.
* from \<a\> - Prints out all edges originating from a.
* help - Displays all available commands.
* print - Prints out a raw bit matrix of all the edges.
* quit - Quits the program.
* remove \<a\> \<b\> - Removes a directed edge from a to b.
* reset - Removes all edges from the graph.
* resize \<n\> - Creates an empty graph with n nodes, from 0 through n-1.
* to \<a\> - Prints out all edges directed to a.
* toggle \<a\> \<b\> - Adds a directed edge from a to b if none exists; otherwise removes the edge.