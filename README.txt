README

USAGE
- As long as the database file is present the application can be run by clicking the green run icon in Netbeans

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
 Mood Cntl: Jian Li- Mood View: Jian Li- Mood Panel: Jian Li- Mood DB: Jian Li-