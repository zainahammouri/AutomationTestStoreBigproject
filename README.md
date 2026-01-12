"# AutomationTestStoreBigproject" 

This project is an end-to-end automated testing framework built to validate the main business flows of an e-commerce website (https://automationteststore.com
) using Selenium WebDriver, TestNG, Java, and MySQL.

The framework covers UI, database-driven testing, and real user scenarios to ensure the stability and reliability of the application.
The Scope of Testing 
1. the First webite to test 

1. Homepage Accessibility
Test Case ID: TC_ATS_001
Objective: Verify that the homepage loads successfully without errors.
Test Steps:
Navigate to https://www.automationteststore.com/.
Expected Result: The homepage loads completely, displaying all primary elements such as navigation menus, banners, and featured products.


2. User Registration Process
Test Case ID: TC_ATS_002
Objective: Ensure that new users can register an account.
Test Steps:
Click on the "Login or register" link.
Fill in the required registration details.
Submit the registration form.
Expected Result: A new user account is created, and a confirmation message is displayed.


3. User Login Functionality
Test Case ID: TC_ATS_003
Objective: Verify that registered users can log in successfully.
Test Steps:
Click on the "Login or register" link.
Enter valid credentials.
Submit the login form.
Expected Result: The user is logged in and redirected to their account dashboard.Automation Exercise


4. Product Search Functionality
Test Case ID: TC_ATS_004
Objective: Ensure that users can search for products using keywords.
Test Steps:
Enter a product name (e.g., "Shampoo") into the search bar.
Press Enter or click the search icon.
Expected Result: A list of relevant products matching the search term is displayed.


5. Filtering Search Results
Test Case ID: TC_ATS_005
Objective: Verify that users can filter search results based on categories (e.g., brand, price).
Test Steps:
Perform a product search.
Apply various filters to the search results.
Expected Result: Search results update to reflect the applied filters.TestGrid+1Sauce Labs+1MuukTest+12BrowserStack+12Reddit+12


6. Viewing Product Details
Test Case ID: TC_ATS_006
Objective: Ensure that users can view detailed information about a product.
Test Steps:
Click on a product from the listings.
Expected Result: The product detail page displays images, specifications, price, availability, and customer reviews.


7. Adding Products to Cart
Test Case ID: TC_ATS_007
Objective: Verify that users can add products to the shopping cart.
Test Steps:
Navigate to a product detail page.
Click the "Add to Cart" button.
Expected Result: The product is added to the cart, and a confirmation message is displayed.


8. Viewing and Modifying the Shopping Cart
Test Case ID: TC_ATS_008
Objective: Ensure that users can view and modify their shopping cart.
Test Steps:
Click on the "Cart" link.
Review the listed products.
Adjust quantities or remove items.
Expected Result: The cart updates accordingly, reflecting changes in quantity and total price.


9. Proceeding to Checkout
Test Case ID: TC_ATS_009
Objective: Verify that users can proceed to the checkout process.
Test Steps:
Click on the "Cart" link.
Click the "Checkout" button.
Expected Result: The checkout page is displayed, showing address details and order summary.HCL Software Help


10. Applying Discount Codes
Test Case ID: TC_ATS_010
Objective: Ensure that users can apply discount codes during checkout.
Test Steps:
Proceed to the checkout page.
Enter a valid discount code in the designated field.
Apply the code.
Expected Result: The discount is applied to the order total, and the updated price is displayed.


11. Viewing Order History
Test Case ID: TC_ATS_011
Objective: Verify that users can view their past orders.
Test Steps:
Log in to the user account.
Navigate to the "Order History" section.
Expected Result: A list of past orders with details such as order number, date, and status is displayed.


12. Managing Account Information
Test Case ID: TC_ATS_012
Objective: Ensure that users can update their account information.
Test Steps:
Log in to the user account.
Navigate to the "Account Information" section.
Update personal details (e.g., address, phone number).
Save the changes.
Expected Result: Account information is updated successfully, and a confirmation message is displayed.


13. Submitting Product Reviews
Test Case ID: TC_ATS_013
Objective: Verify that users can submit reviews for products.
Test Steps:
Navigate to a product detail page.
Click on the "Write Review" link.
Enter review details and submit.
Expected Result: The review is submitted and displayed under the product reviews section.Reddit+3LambdaTest+3Wikipedia+3


14. Newsletter Subscription
Test Case ID: TC_ATS_014
Objective: Ensure that users can subscribe to the newsletter.
Test Steps:
Enter an email address into the newsletter subscription field.
Click the "Subscribe" button.
Expected Result: A confirmation message is displayed, indicating successful subscription.


15. Logging Out of the Account
Test Case ID: TC_ATS_015
Objective: Verify that users can log out of their accounts successfully.
Test Steps:
Click on the "Logout" link.
Expected Result: The user is logged out and redirected to the homepage or login page.
