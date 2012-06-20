import java.util.Scanner;

public class GraphTool {
	public static String help="add <a> <b> - Adds a directed edge from a to b.\ncheck <a> <b> - Checks whether a directed edge from a to b exists.\nfrom <a> - Prints out all edges originating from a.\nhelp - Displays all available commands.\nprint - Prints out a raw bit matrix of all the edges.\nquit - Quits the program.\nremove <a <b> - Removes a directed edge from a to b.\nreset - Removes all edges from the graph.\nresize <n> - Creates an empty graph with n nodes, from 0 through n-1.\nto <a> - Prints out all edges directed to a.\ntoggle <a> <b> - Adds a directed edge from a to b if none exists; otherwise removes the edge.";
	
	public static void main(String[] args) {
		NonWeightedGraph graph;
		int size=0;
		Scanner scan=new Scanner(System.in);
		
		boolean valid=false;
		while (!valid) {
			System.out.print("How many nodes should the graph have? ");
			try {
				size=Integer.parseInt(scan.nextLine());
				if (size<1)
					System.out.println("Error: Invalid size");
				else {
					valid=true;
				}
			} catch (NumberFormatException e) {
				System.out.println("Error: Invalid number");
			}
			System.out.println();
		}
		
		graph=new BitwiseAdjacencyMatrix(size);
		System.out.println("Enter \"help\" to see a list of possible commands.");
		
		boolean quit=false;
		String command;
		
		while (!quit) {
			System.out.print("> ");
			command=scan.nextLine();
			int end=command.indexOf(' ')>-1?command.indexOf(' '):command.length();
			
			String start=command.substring(0,end);
			if (start.equals("add")) { //a b
				try {
					int a=Integer.parseInt(command.substring(4,command.indexOf(' ',4))),b=Integer.parseInt(command.substring(command.indexOf(' ',4)+1,command.length()));
					if (a<0||a>=size||b<0||b>=size)
						System.out.println("Error: Invalid node");
					else {
						graph.addEdge(a,b);
						System.out.println("Completed");
					}
				} catch (NumberFormatException e) {
					System.out.println("Error: Invalid number");
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Error: Invalid syntax");
				}
			} else if (start.equals("remove")) { //a b
				try {
					int a=Integer.parseInt(command.substring(7,command.indexOf(' ',7))),b=Integer.parseInt(command.substring(command.indexOf(' ',7)+1,command.length()));
					if (a<0||a>=size||b<0||b>=size)
						System.out.println("Error: Invalid node");
					else {
						graph.removeEdge(a,b);
						System.out.println("Completed");
					}
				} catch (NumberFormatException e) {
					System.out.println("Error: Invalid number");
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Error: Invalid syntax");
				}
			} else if (start.equals("toggle")) { //a b
				try {
					int a=Integer.parseInt(command.substring(7,command.indexOf(' ',7))),b=Integer.parseInt(command.substring(command.indexOf(' ',7)+1,command.length()));
					if (a<0||a>=size||b<0||b>=size)
						System.out.println("Error: Invalid node");
					else {
						if (graph.hasEdge(a,b))
							graph.removeEdge(a,b);
						else
							graph.addEdge(a,b);
						System.out.println("Completed");
					}
				} catch (NumberFormatException e) {
					System.out.println("Error: Invalid number");
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Error: Invalid syntax");
				}
			} else if (start.equals("check")) { //a b
				try {
					int a=Integer.parseInt(command.substring(6,command.indexOf(' ',6))),b=Integer.parseInt(command.substring(command.indexOf(' ',6)+1,command.length()));
					if (a<0||a>=size||b<0||b>=size)
						System.out.println("Error: Invalid node");
					else {
						if (graph.hasEdge(a,b))
							System.out.println("There is a edge from "+a+" to "+b+".");
						else
							System.out.println("There is not a edge from "+a+" to "+b+".");
					}
				} catch (NumberFormatException e) {
					System.out.println("Error: Invalid number");
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Error: Invalid syntax");
				}
			} else if (start.equals("print")) {
				for (int i=0;i<size;i++) {
					for (int j=0;j<size;j++)
						if (graph.hasEdge(i,j))
							System.out.print("1");
						else
							System.out.print("0");
					System.out.println();
				}
			} else if (start.equals("to")) { //a
				try {
					int a=Integer.parseInt(command.substring(3,command.length()));
					if (a<0||a>=size)
						System.out.println("Error: Invalid node");
					else {
						for (int i:graph.getVerticesTo(a))
							System.out.print(i+"->"+a+" ");
						System.out.println();
					}
				} catch (NumberFormatException e) {
					System.out.println("Error: Invalid number");
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Error: Invalid syntax");
				}
			} else if (start.equals("from")) { //a
				try {
					int a=Integer.parseInt(command.substring(5,command.length()));
					if (a<0||a>=size)
						System.out.println("Error: Invalid node");
					else {
						for (int i:graph.getVerticesFrom(a))
							System.out.print(a+"->"+i+" ");
						System.out.println();
					}
				} catch (NumberFormatException e) {
					System.out.println("Error: Invalid number");
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Error: Invalid syntax");
				}
			} else if (start.equals("reset")) {
				graph=new BitwiseAdjacencyMatrix(size);
				System.out.println("Completed");
			} else if (start.equals("resize")) {
				try {
					int newSize=Integer.parseInt(command.substring(7,command.length()));
					if (newSize<1)
						System.out.println("Error: Invalid size");
					else {
						size=newSize;
						graph=new BitwiseAdjacencyMatrix(size);
						System.out.println("Completed");
					}
				} catch (NumberFormatException e) {
					System.out.println("Error: Invalid number");
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Error: Invalid syntax");
				}
			} else if (start.equals("quit")) {
				quit=true;
			} else if (start.equals("help")) {
				System.out.println(help);
			} else
				System.out.println("Error: Invalid command");
			
		}
	}
}