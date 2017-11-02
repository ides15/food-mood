README

USAGE
- In order to run the application, open the project in NetBeans IDE.

- When opening the project for the first time, the IDE will ask you to 'Resolve Project Problems' and will have selected the sqlite driver. That driver is located here:

https://bitbucket.org/xerial/sqlite-jdbc/downloads/sqlite-jdbc-3.20.0.jar (download link).

Save it to your local machine.

- Upon saving the sqlite driver to your local machine, resolve the project problems by clicking 'Browse', browsing to where you saved the driver, and then selecting it.

- When the driver problem is solved, all you need to do to run the project is to click the 'Run' button at the top of the IDE (green button).

AUTHENTICATION
- There are currently four user accounts in the database. Usernames and passwords are all lowercase:
	username: john
	password: ide

	username: kyle
	password: ryan

	username: dylan
	password: trang

	username: jian
	password: li

DESIGN PATTERNS
- John Ide implemented a factory design pattern and a user input feedback pattern.
	- The factory pattern is located on the 'Pick a New Entry:' screen. Depending on which button you click (new food, drink, or mood), thefactory will instantiate a new model, view, and controller for that entry.
	- The factory class is located in the app package, under the name 'EntryCntlFactory.java'.
	- Examples of the user input feedback pattern can be found either on the main login screen (entering an	incorrect password), or on the 'View Profile' screen (saving a new password).
- Kyle Ryan implimented a sudo-builder oo pattern along with input prompts.
	- The sudo-builder pattern exists in the foodCntrl class. All of the important objects such as JPanels, navCntrl, and Food_Table. With this implimentation we are allowed to have full access to all of our food related objects and methods through one interface.
	- On the addFoodPanel JPanel is where I implimented the input prompt. The filler text for the text box gives the user an idea of how to format their data to ensure consistency.

IMPLEMENTATION
- Authentication : John Ide
- New user addition : John Ide
- Main app navigation : John Ide
- User Profile CRUD : John Ide
- New entries page : John Ide
- Food deletion : John Ide
- Food addition : John Ide
- Food Package : Kyle Ryan
- Food_Table : Kyle Ryan
- Food Model : Kyle Ryan
- Food Create : Kyle Ryan
