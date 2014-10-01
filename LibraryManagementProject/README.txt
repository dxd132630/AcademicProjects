####################################################################################################################################################################															Library Management System 10.1 README file															 #
#															 Author: Deepti Deshpande UTD_ID:2021204846															  #
###################################################################################################################################################################
Set up insetrctions:
Database setup instructions:

1.Open the DB console
2.Type:
	> delimiter //
3.Copy the commands in Creates_and_Triggers.sql file and hit enter this will create 7 tables and 2 triggers as per the Project schema requirement

Fornt end set up instructions:	
1.The application is Java based application developed on NET BEANS IDE version 7.4 and MySQL Server 5.6
2.Attached folder has the Java exported project named dxd132630_LMS which intern has a JavaApplication1 folder
3.Inside the JavaApplication1 folder are the Java source files and related libraries
4.Import java project in Netbeans IDE
5.Complie and run the GUItoLibSys.java file in the source folder
7.Commandline execution procedure is as follows:
	a.Copy all the files and sub files in the folder dxd132630_LMS to user specific location
	b.Locate the java source file location in MS-DOS LIKE "C:\Users\Deepti\Documents\NetBeansProjects\JavaApplication1\src\"
	c.Complie the java file using the command:
		>javac GUItoLibSys.java
	d.Execute the java file using:
		>java GUItoLibSys
8.Change tje user name and password as per your DB server user name and password in the .java file as  they are hardcoded.
9.Application usage docment is in the attached folder which has the details of Library System Management 10.1.
	
		