package com.csprep.csprep;

import java.util.ArrayList;
import java.util.Random;

	/**
	 * Category input is case sensitive
	 * Expected input(actual category): Java(java), Object(Object oriented programming), Data(Data Structs/Algorithms),
	 * 									C++(C/C++), Linux(linux)
	 * 
	 * Creation and request example:
	 * 	ScoreAndQuestions q = new ScoreAndQuestions();
	 * 	String quest = q.getQuestion("Java");
	 *
	 * Check answer (Send the String that the user chose):
	 * 	q.checkAnswer("");
	 * 
	 * Package:
	 * 	q.getScore();
	 *	
	 */
public class ScoreAndQuestions {

	private static int currentScore;
	private static Random rand;
    private static ArrayList<QNode> java;
    private static ArrayList<QNode> OOP;
    private static ArrayList<QNode> dataStructsAlgs;
    private static ArrayList<QNode> CCplusplus;
    private static ArrayList<QNode> linux;
    static QNode currentNode;

    public ScoreAndQuestions(){
        currentScore = 0;
        rand = new Random();
        currentNode = new QNode("", "", "", "");
        java = new ArrayList<QNode>();
        OOP = new ArrayList<QNode>();
        dataStructsAlgs = new ArrayList<QNode>();
        CCplusplus = new ArrayList<QNode>();
        linux = new ArrayList<QNode>();
        createJava(java);
        createOOP(OOP);
        createDataStructsAlgs(dataStructsAlgs);
        createCCplusplus(CCplusplus);
        createLinux(linux);
    }

    //public static int getScore(){ return currentScore;}

    //public static void increaseScore(){currentScore++;}

    public static String getQuestion(String type){
        if(type.contains("Java")){
            currentNode = java.get(rand.nextInt(java.size()));
            String s = currentNode.getQuestion();
            return s;
        } else if(type.contains("Data")){
            currentNode = dataStructsAlgs.get(rand.nextInt(dataStructsAlgs.size()));
            String s = currentNode.getQuestion();
            return s;
        } else if(type.contains("Object")){
        	currentNode = OOP.get(rand.nextInt(OOP.size()));
            String s = currentNode.getQuestion();
            return s;
        } else if(type.contains("C++")){
        	currentNode = CCplusplus.get(rand.nextInt(CCplusplus.size()));
            String s = currentNode.getQuestion();
            return s;
        } else if(type.contains("Linux")){
        	currentNode = linux.get(rand.nextInt(linux.size()));
            String s = currentNode.getQuestion();
            return s;
        }
        
        return null;
    }

    /*
    public static boolean checkAnswer(String input){
	    boolean b = currentNode.checkAnswer(input);    
    	if(b){
    		increaseScore();
    		return b;
    	}
    	return b;
	}*/

    public static void createJava(ArrayList<QNode> java) {
        java.add(new QNode("What is a static variable?", "A variable with a fixed location in memory that's common to all objects in a class",
        		"A variable that is not common to all objects in a class", "A variable that might have been changed by something outside of the class"));
        java.add(new QNode("What is a static method?", "A method that can be invoked without creating an instance of the class it is from", 
        		"A method that only uses static variables", "A method that is redefined in another class"));
        java.add(new QNode("What does 'this' reference?", "The current object", "The current variable", "The current thread"));
        java.add(new QNode("What are three exception handling blocks?", "Try, catch, finally", "Main, try, throws", "Throw, throws, finally"));
        java.add(new QNode("What does 'final' do to a variable?", "The variable definition cannot change", "The variable data is erased", "The variable becomes a constant"));
        java.add(new QNode("What does 'throw' do?", "Throws an exception", "Declares what exception can be thrown", "None of the above"));
        java.add(new QNode("What does 'throws' do?", "Declares what exception can be thrown", "Throws an exception", "None of the above"));
        java.add(new QNode("Is Java Pass-by-reference or Pass-by-value", "Pass-by-value", "Pass-by-reference", "Both"));
        java.add(new QNode("What operator should be used to compare two strings?", ".equals()", "==", "="));
        java.add(new QNode("How do you convert a String to a number in Java?", "Integer.valueOf()", "(int)", ".IntVal()"));
    }
    
    public static void createOOP(ArrayList<QNode> OOP){
        OOP.add(new QNode("What are the main features of OOP?", "Abstraction, polymorphism, inheritance, encapsulation", "Encapsulation, inheritance",
        		"Static, abstraction, encapsualtion")); 
        OOP.add(new QNode("What is method overloading?", "Multiple methods with the same name and different parameters", "A class method that is redefined",
        		"An error when too many arguments are passed into a method"));
    	OOP.add(new QNode("What are the advantages of encapsulation?", "Modularity, maintenance, protection", "Abstraction, polymorphism", "None of the above"));
        OOP.add(new QNode("What is polymorphism?", "A type whose operations can be applied to values of some other type", "A child class acquires the methods and fields of it's parent class",
        		"The same thing as encapsulation"));
        OOP.add(new QNode("What is inheritance?", "A child class acquires the methods and fields of it's parent class", "A type whose operations can be applied to values of some other type",
        		"The same thing as encapsulation"));
        OOP.add(new QNode("What function is called automatically when an object is created?", "Constructor", "Constant", "Static"));
        OOP.add(new QNode("What is an object?", "An instance of a class", "A class", "An instance of a variable"));
        OOP.add(new QNode("What is a package?", "A namespace for organizing classes and interfaces", "A group of variables", "An import"));
        OOP.add(new QNode("What is a collection of methods with no implementation called?", "Interface", "Package", "Class"));
        OOP.add(new QNode("What is the implementation of an object's behavior?", "Methods", "Algorithms", "Data structures"));
    }

    public static void createDataStructsAlgs(ArrayList<QNode> dataStructsAlgs) {
        dataStructsAlgs.add(new QNode("What is the average big o of bubble sort?", "O(n^2)", "O(n)", "O(log n)"));
        dataStructsAlgs.add(new QNode("What is the main difference between a stack and a queue?", "Stack is LIFO, queue is FIFO", "Stack is FIFO, queue is LIFO",
        		"Nothing. Both are FIFO"));
        dataStructsAlgs.add(new QNode("Properties of a binary search tree?", "Value of root node is more than left child and less than right child", "Both child nodes are less than the parent node",
        		"All branches are the same height"));
        dataStructsAlgs.add(new QNode("What data structure is used for recursion?", "Stack", "Queue", "HashMap"));
        dataStructsAlgs.add(new QNode("When does a BST have a big o of n?", "When the tree looks like a stick", "When the tree is perfectly balanced", "Never"));
        dataStructsAlgs.add(new QNode("What is the average big o of merge sort?", "O(n log n)", "O(log n)", "O(n)"));
        dataStructsAlgs.add(new QNode("How many stacks are required to implement a queue?", "Two", "One", "Two + one extra space"));
        dataStructsAlgs.add(new QNode("When selecting a pivot for Quicksort, which is the best choice for optimal partitioning?", "The median of the array",
        		"The last element of the array", "The middle element of the array"));
        dataStructsAlgs.add(new QNode("What is a greedy algorithm?", "An algorithm that makes the optimum local choice at each stage",
        		"An algorithm that considers all possible outcomes of each decision", "None of the above"));
        dataStructsAlgs.add(new QNode("Which of the following is a divide-and-conquer algorithm?", "Merge sort", "Insertion sort", "Bubble sort"));
    
    }
    
    public static void createCCplusplus(ArrayList<QNode> CCplusplus){
    	CCplusplus.add(new QNode("What does realloc() do?", "Changes the size of the block of memory pointed to", "Allocates a new block of memory", "Frees the block of memory allocated by malloc"));
    	CCplusplus.add(new QNode("What does free() do?", "Frees the block of memory allocated by malloc", "Catches an error", "Closes the program"));
    	CCplusplus.add(new QNode("How many words can be read at one time by cin", "One", "An entire file", "Until the end of line character"));
    	CCplusplus.add(new QNode("A null character takes up _ byte(s)", "1", "0", "8"));
    	CCplusplus.add(new QNode("How many arguments does a destructor have?", "0", "2", "1"));
    	CCplusplus.add(new QNode("Difference between a class and structure?", "Class members are private and classes bind data", "Struct members are private and structs bind data", "They work the same way"));
    	CCplusplus.add(new QNode("What is a dangling pointer?", "The address of an object is used after it's lifetime is over", "A pointer is being passed by reference", "A pointer has just been created"));
    	CCplusplus.add(new QNode("What is the main difference between C and C++", "C is a procedural language, C++ is a procedural and Object Oriented language",
    			"C++ is a procedural language, C is a procedural and Object Oriented language", "C++ is for front-end development, C is for back-end development "));
    	CCplusplus.add(new QNode("What operator dereferences a pointer?", "*", "&", "#"));
    	CCplusplus.add(new QNode("What is a common reason for a segmentation fault", "NULL pointer", "Missing bracket", "I/O issue"));
    }
    
    public static void createLinux(ArrayList<QNode> linux){
    	linux.add(new QNode("What is the difference between Linux and Unix?", "Linux is open source", "Unix is open source", "They are the same"));
    	linux.add(new QNode("What is the Linux Kernal?", "It provides an interface for user-level action", "The default shell", "A nickname for Linux"));
    	linux.add(new QNode("What is the root account?", "It's similar to a systems administrator account", "The last account created", "The only user account available on Linux"));
    	linux.add(new QNode("What are symbolic links?", "Shortcut links to programs/files/directories", "A Linux only data structure", "Linux commands"));
    	linux.add(new QNode("Does the Ctrl+Alt+Del key combination work on Linux?", "Yes, it reboots Linux", "Yes, it stops the current process", "No"));
    	linux.add(new QNode("What are filenames that are preceded by a dot?", "Hidden files", "Nothing, illigal name", "HTML files"));
    	linux.add(new QNode("What are the kinds of permissions under Linux?", "Read, write, execute", "Stop, start", "Command, edit, exit"));
    	linux.add(new QNode("How do you insert comments in the command line prompt?", "#", "//", "@"));
    	linux.add(new QNode("Command to list directory contents", "dir", "pwd", "list"));
    	linux.add(new QNode("Command to create a new folder", "mkdir", "make", "new"));
    }
}