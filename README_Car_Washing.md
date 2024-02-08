#Hackathon Project Requirements

#The outcomes of Hackathon deliverables are:

Explore the Innovative Implementations.
Implement Best practices such as creating Smoke and Regression suite.
Implement Maven on the created automation test scripts
Explore Jenkins to execute the test scripts periodically on Selenium Grid.
Explore Selenium Grid to run test scripts on different platforms and against different browsers.
Integrate Jenkins with version controller (GIT) and scheduled builds to run automatically.

#Identify New Bikes

#Problem Statement : Identify Car Wash Services

Display 5 Car washing services name and phone numbers
1. Car washing services near you with highest rating on top.
2. Rating should be more than 4*

Detailed Description: Hackathon Ideas

1. Display 5 Car washing services name and phone numbers, near your location with highest rating (more than 4) on top
2. Try to register for Free Listing, fill the form with any one input invalid (example: email); Capture the error message & display 
3. Go to Gym and retrieve all sub-category items and store in a List; Display the same

#Key Automation Scope

Handling Alert, search option
Multiple navigation path for one page
Filling form (in different objects in web page)
Capture warning message
Extract menu items & store in collections
Navigating back to home page

#Selenium Automation Testing Project: Identify New Bikes
 
##Project Overview
This Selenium automation testing project focuses on automating tasks on asklaila.com.
The primary objectives include capturing user information, navigating through the portal, verifying the presence of specific elements. 
The project uses various dependencies and libraries to facilitate automation.


##Project Structure
 
###1. Maven Repository
 
- *Maven Version*: 3.9.3
 
###2. Dependencies
 
- *Apache POI*
  - Version: 5.2.2
  - Purpose: Used for reading and writing Excel files, facilitating data-driven testing.
 
- *TestNG*
  - Version: 7.7.1
  - Purpose: Framework for test automation that allows for parallel execution and flexible test configuration.
 
- *Extent Report*
  - Version: 5.0.9
  - Purpose: Generates interactive and detailed HTML reports to enhance test result analysis.
 
- *Selenium*
  - Version: 4.15.0
  - Purpose: Enables interaction with web elements, navigation, and form submission in the browser.
 
- *Loggers*
  - Version: 2.20.0
  - Purpose: Provides logging capabilities for better debugging and traceability.
 
##Automation Test Flow
 
1. *Open asklaila.com*
   - Navigate to the asklaila.com.
 
2. *Click on the Location*
   - Click on India.
   - Click on Bangalore.
 
3. *Search Car Washing Services*
   - Search Car Washing Services in the searchbox.
   - Click on the Search button.
 
4. *Display Top 5 Car Washing Services*
   - Select top 5 Car Washing Services with highest ratings.
   - Print the name, rating and phone numbers of those Car Washing Services.
   - Take screenshot of the page .
   
5. *Give some review to the Car Washing Services*
   - Click on the Write Review button.
   - Give some review and take the screenshot of the page.
   - Navigate back to Car Washing page.
 
6. *Open the two different sharing pages*
   - Click on the share button.
   - Click on the Facebook icon.
   - Give some invalid inputs to the email and password.
   - Take the screenshot and close the Facebook page.
   - Click on the twitter icon.
   - Take the screenshot and close the Twitter page.
 
7. *Report some issues to the Car Washing Services*
   - Click on the report button.
   - Give some reports to the textbox and click on the report button.
   - Take the screenshot and navigate back to the Car Washing Page.
 
8. *Register for Freelisting and fill the form with input invalid*
   - Click on the Freelisting button.
   - Click on Here to Login button.
   - Give some invalid inputs to the email and password textbox.
   - Click on the Login Button.
   - Take the screenshot and navigate to the homepage.
 
9. *Go to the Gym page and print all the sub categories*
   - In the homepage scroll down upto Gyms.
   - Click on Gyms.
   - In the Gym page click on the dropdown Sub-Category.
   - Print all the sub categories and take the screenshot.
   - Close the browser.
 
##How to Run the Tests
 
1. *Open Eclipse IDE:*
   - Launch Eclipse IDE on your machine.
 
2. *Import Project:*
   - Select File -> Import from the menu.
   - Choose Existing Maven Projects and click Next.
   - Browse to the directory where you cloned the repository and select the project.
 
3. *Update Maven Project:*
   - Right-click on the project in the Project Explorer.
   - Choose Maven -> Update Project.
   - Click OK to update dependencies.
 
4. *Set Up Configuration:*
   - Open the src/test/resources/config.properties file.
   - Update any configuration parameters like browser type, URLs, etc., as needed.
 
5. *Run Test Suite:*
   - Locate the test suite file (e.g., src/test/java/TestSuite.java).
   - Right-click on the file and choose Run As -> TestNG Suite.
 
6. *View Reports:*
   - After execution, open the test-output folder.
   - Find the Extent Report HTML file (index.html) for detailed test reports.
 
##Author Information
 
- *Ramendu Ghosal(2303477)*
 
##Disclaimer
 
This project is intended for educational and testing purposes only. The authors are not responsible for any unauthorized use or modification of the code. Use at your own risk.