# Project-2-Inventory
Instructions: Create a document, and edit (and delete as appropriate) the text in red during the appropriate week.  Do not change what you have written in previous weeks!  If you prefer, you may embed a Word/PDF document under each Week header.  Do not link to a Google Doc; if you want to use a Google Doc you can export to PDF and embed the PDF in this page. Submit your document each week in the Project Assignment.
Week 1: Project Proposal
Planned Working Time
Every Tuesday/Thursday: 12-4
Saturday/Sundays: 12-4

Project Pitch:
Think about how a pitch on a crowdsourced funding platform (like Kickstarter or GoFundMe) might look. You should have several paragraphs describing your project, and some “faked” screenshots.  For the “faked” screenshots, you should mock-up the way the program will look when it runs, without actually writing the program.  At this point, your “faked” screenshots may be hand drawn or be created with a drawing program; they should include a GUI design or a sample of program text output.
Include information about how the user interacts with the program (e.g.  what happens when the user clicks on a button or types in a text field?).

Designing an inventory store system of a variety of electronics that Employees may want to look up or add to the inventory system. This would mainly include for the products for TVs and computers. The inventory will hold different types of TVs as well as different screen sizes for TVs and computers.  Through the use of GUI the user will have the option to view the entire inventory, or add or check a specific product for the quantity.

Adding inventory: Employees should be able to add quantities of products to inventory. 
They can do this by simply clicking the add button, which will prompt the user into a new window to go through the specifications to know which product the user will be adding into the inventory.  Towards the end of the specification window, it will allow the user to add the quantity of that item.  Once the specifications has been selected and the number of quantity has been inputted, it will update the inventory system with a new product or update the quantity number. 
 
Searching inventory: Employees should be able to search up products by the same way they’re adding inventory. The user will be prompted for category then specific information such as type of TV, screen size, etc. The program will then try to find the item based on the specifications chosen and inform the user the amount of that product.

GUI implementation:
Start with JFrame
![Main Window](https://user-images.githubusercontent.com/89431035/200916613-c8dbedc9-5ef2-43bf-a118-e53499a3c8c3.png)
Add buttons on JFrame for "Add" and "Check"
When user clicks "Add" or "Check"
A new window for selecting specifications for TV or computer will appear.
![Add Frame](https://user-images.githubusercontent.com/89431035/200916815-e656e376-0eca-4969-ab6a-5dab1bcb85cd.png)
Will have a cancel button in case user would like to go back to the main menu.


UML Diagram
Include a UML diagram or other description of the classes and interfaces you anticipate needing to write, including details about fields and methods, and class/interface responsibilities.
Object-Oriented Design
Explain your Object Oriented project design in a video.  Embed the video on the page. If either partner has not yet demonstrated Middle Developer proficiency for LO1, that person should record their own video and submit it in Project 1 Middle Developer Explanations (Make video at home). Only one video is required to be embedded in this page.
Learning Outcomes
Briefly outline how your project will demonstrate each of the required LOs.
LO1: Employ design principles of object-oriented programming
LO2: Construct programs utilizing single and multidimensional arrays
LO3: Construct programs utilizing object and classes in object-oriented programming, including aggregation
LO4: Construct programs utilizing inheritance and polymorphism, including abstract classes and interfaces
LO5: Construct programs utilizing exception handling
LO6: Construct programs utilizing text file I/O
LO7: Construct programs utilizing graphical user interfaces utilizing event-driven programming.
Our project will demonstrate the usage of gui by allowing the user to visually select "Add" or "Check" through a button and then be able to also potentially view the entire inventory on the right side panel of the main frame.  Depending on whether the user selects "Add" or "Check" a similar new window will appear that will give the user selection options for the specifications of the product.  When selecting "add", the user will be able to either add a new product into the inventory or update the quantity of the product and will have a pop up window to show the quantity.  When "check" is selected the user will be able to view the quantity of that item in a new pop up window.


Timeline:
Create a timeline of goals to accomplish each week. You may start with the sample timeline template below, but should fill in project-specific details.
 
Sample Project Timeline Goals:
Week 1
Project proposal written.
Included picture diagram of how our design will look.  Designed our GUI model through paint.  Got a head start on coding the main Jframe and to have it open a new window when "Add" or "Check" has been selected.  Still brainstorming on exactly how we will implement our entire project 1 code into our project 2.  Understand how to work with github and how to connect our repository from github to eclipse.  Figure out how to commit and push changes back onto our github repository so we can streamline our code workflow.

Week 2
Continue working on implementing our GUI windows so that the user will be able to smoothly add or check for products in the inventory.
Add event handling to make the GUI functional and to respond a certain way when the buttons are pressed.
Develop test cases and test code to make sure that our program will run the way we want.
Determine if exception handling will be necessary to ensure the program fails gracefully.  We also want to design our GUI with the focus of making it user friendly so there will be less room for the user to make an error.
Update project page with progress details.
Submit code written so far.

Week 3
Figure out a way to display our inventory potentially on the main JFrame window.
Finalize integrating GUI into our project 1.
Test, test, test, debug, and test some more.
Update project page with progress details.
Submit code written so far.

Week 4
Debug any remaining problems.  Make sure that the program runs smoothly.  Potentially have our peers try to break our code or test it.
Create project demonstration video, including information about how each LO is used as part of the project.
Submit final code on Canvas, and add videos to project page.

Note: It is acceptable for your plan and timeline to change as you write the code.
Github Repository
Provide the URL to the Github repository for the project. If you are continuing from Project 1, you can upload (add, commit, push) your current project. If you have started writing code, submit the code you have written so far, even if it is not complete and/or has compiler errors.
Week 1 Additional Deliverables:
Deliverable 2 (required, on the Canvas Project 2 submission): Provide a link to your Github repository as a submission comment. If your repository is private, invite the instructor to join.


 
Week 2: Updates
Work on your Week 2 goals from your project timeline.
Week 2 Deliverables
Deliverable 1 (on GitHub): Commit and push the code you have written so far, even if it is not complete and/or has compiler errors. 
Deliverable 2 (here): Update your Canvas Project 2 page from Week 1.  Please add to the page - do not delete any content from Week 1:
Share a screenshot of the GUI.
Add a journal-like entry about your experience writing code this week to your Canvas project page:
What design changes have you decided to make, and why did you make them?
What challenges have you encountered?
What do you still need to do to complete the project?
Update your timeline goals, if needed.
 
Week 3: Updates
Work on your Week 3 goals from your project timeline.
Week 3 Deliverables
Deliverable 1 (on GitHub): Commit and push the code you have written so far, even if it is not complete and/or has compiler errors. 
Deliverable 2 (here): Update your Canvas Project 2 page from Week 1.  Please add to the page - do not delete any content from Week 1 or Week 2:
Share a screenshot of the GUI.
Add a journal-like entry about your experience writing code this week to your Canvas project page:
What design changes have you decided to make, and why did you make them?
What challenges have you encountered?
What do you still need to do to complete the project?
Update your timeline goals, if needed.
 
Week 4: Project Wrap-up
Finish writing any other necessary code and debug (although hopefully you were debugging as you wrote the code!).  
Week 4 Deliverables
Deliverable 1 (on the Canvas Project 2 submission): Submit your final version of code (make sure to also commit and push to Github).  It should be free of compiler and run-time errors.
Deliverable 2 (here): Update your Canvas Project 2 page from Week 1.  Please add to the page - do not delete any content from Weeks 1, 2, or 3:
Share a screenshot of the text interaction with the user.
Add a journal-like entry about your experience writing code this week to your Canvas project page:
What design changes did you make during the project, and why did you make them?
What challenges did you encounter?
What could you do to expand on and improve your project?
If you were to start the project from scratch, what would you do differently?
Optionally, you may choose to share your code with your classmates by linking to your Eclipse project here.
Deliverable 3 (here): Share your video demonstration of your project and explanation of how and why the project utilized the concepts from the Learning Objectives; you only need to address the LOs for which you have not yet demonstrated Senior Developer proficiency.  Aim for your video to be around 5 minutes, and do not exceed 10 minutes in length. Each partner must create their own video to demonstrate Senior Developer proficiency.
If you have not previously demonstrated Middle Developer proficiency for a LO, use your project code to make a video for that LO.  Senior Developer proficiency will not be evaluated until Middle Developer proficiency is demonstrated.

