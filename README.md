# Club/Organisation Management System (Android App)

An Android application developed in **Java** and **XML** to manage club activities, member registrations, and administrative tasks.

> ⚠️ **Project Status:** Under Development. The core logic and UI are currently being implemented based on the UML specifications.

## 🏗️ System Architecture

### Use Case Diagram
The following diagram defines the functional scope and user interactions for the mobile application.

<img src="./uml%20diagram/bin/use_case.png" width="70%" />

### Logic Overview
* **Identity Management**: Visitors can use the **Create Account** feature to become Members.
* **Hierarchical Access**: Admins and Moderators inherit all standard Member permissions.
* **Security Layer**: All protected actions (like managing members or news) trigger an `«include»` relationship to the **LogIn** and **Authentication** modules.
* **Feature Extensions**: Event registration allows for optional flows like **Payment** (via external API) and **Attendance Confirmation**.

## Class Diagram
The following diagram defines the structural blueprint and data relationships governing the application.

<img src="./uml%20diagram/bin/class.png" width="70%" />

### Logic Overview
* **Role-Based Permissions:** Uses a `Role` attribute to grant **Admins** and **Moderators** "Manage" access to News and Events.
* **Participation Bridge:** A `Participation` class links Members to Events to track `AttendanceStatus` and `EventRole` individually.
* **Centralized Payments:** Uses `PaymentType` and `ReferenceId` to manage both memberships and event fees in one table.
* **Content Traceability:** Links every News post to a `Member` (Author) for clear accountability.
* **OOP Standards:** Implements strict encapsulation with private attributes and public methods for data integrity.

## Sequence Diagrams
These diagrams show how the user and the database talk to each other to get tasks done.

### 1. Create Account
Shows the steps a visitor takes to sign up for the platform and how the system handles different data validation scenarios.

<img src="./uml%20diagram/bin/createAccount_sequence.png" width="70%" />

### 💡 Logic Overview (How it works)
* **Initial Submission:** A Visitor submits their details via the SignUp Form, which are then sent to the Controller for verification.
* **Email Verification:** The system queries the DB to check if the provided email address is already in use.
* **Scenario A (Data is Valid & Email New):** If the data is valid and the email doesn't exist, the Controller generates a password, saves the new account to the DB, and triggers the Emailing System to send the credentials to the user.
* **Scenario B (Email Exists):** If the email is already registered, the Controller redirects the flow to the Authentication module to authenticate the existing user.
* **Scenario C (Invalid Data):** If the data fails validation, the SignUp Form displays an "invalid data" error message to the visitor.

### 2. Member Login
Shows the steps a user takes to access their account and how the system handles successful and failed login attempts.

<img src="./uml%20diagram/bin/logIn_sequence.png" width="70%" />

### 💡 Logic Overview (How it works)
* **Credentials Submission:** The User enters their email and password into the LogIn Form, which forwards the data to the Controller.
* **Identity Verification:** The Controller sends the credentials to the Authentication module, which performs an internal "validate user" check.
* **Success Path (Data Valid):** The Authentication module confirms success to the Controller.
   * The LogIn Form displays a success message and triggers a redirect to the main page.
* **Failure Path (Else):** If validation fails, the Authentication module returns a failure signal.
   * The LogIn Form displays a "failed to login" error message to the User.

### 3. Recover password
Shows the steps a user takes to reset their credentials and receive a temporary password via email.

<img src="./uml%20diagram/bin/recoverPassword_sequence.png" width="70%" />

---

### 💡 Logic Overview (How it works)
* **Trigger:** The process begins when a User requests a recovery form from the Login Form interface.
* **Validation:** The Emailing System performs a self-check to verify if the provided email address exists/is valid.
* **Conditional Logic (Alt):** If the email is valid, the Controller generates a new password, saves it to the DB (Database), and triggers the Emailing System to send the new credentials to the user.
* **Security:** The system ensures the database is only updated after the email identity has been verified by the emailing subsystem.

### 4. Event Registration & Cancellation
Shows the steps a user takes to browse eventResponses, register for a specific event, and the option to cancel their participation.

<img src="./uml%20diagram/bin/eventRegistration_sequence.png" width="70%" />

---

### 💡 Logic Overview (How it works)
* **Navigation:** The User interacts with the AppMain page to view the eventResponses list and drill down into specific event details.
* **Registration Flow:** Clicking "register" triggers a call to the Controller, which persists a "new participation" record in the DB.
* **Dynamic UI:** Upon successful registration, the AppMain page updates the interface locally by swapping the "register" button for "confirm & cancel" options.
* **Cancellation Flow:** If the user clicks "cancel," the Controller instructs the DB to delete the participation record, and the UI reverts the buttons back to the original "register" state.

### 5. Confirm Registration
Shows the final steps a member takes to verify availability and secure their spot in an event.

<img src="./uml%20diagram/bin/confirmRegistration_sequence.png" width="70%" />

---

### 💡 Logic Overview (How it works)
* **Availability Verification:** When a Member clicks confirm, the Controller first checks the DB to ensure there are still open spots.
* **Capacity Constraint:** If available places are 0, the system triggers a "confirmation failed" response and displays an error message to the user.
* **Success Path:** If places are available, the Controller proceeds with the confirmation logic.
* **UI Update:** Upon a successful confirmation, the AppMain page displays a success message and changes the button text to "confirmed".

### 6. External Payment System
Shows the logic for handling event fees, including free eventResponses and external transaction verification.

<img src="./uml%20diagram/bin/paymentSystem_sequence.png" width="70%" />

---

### 💡 Logic Overview (How it works)

* **Fee Verification:** The Controller starts by checking the required payment amount in the DB.

* **Scenario A (No Fees):**

    * If the payment amount is 0, the system automatically marks the payment as successful without external calls.

* **Scenario B (Fees Required):**

    * The system redirects the user to the External Payment System.

    * The external provider performs a verify payment check.

* **Transaction Results:**

    * **Success:** If the payment is successful, the method returns the payment details to the Controller, which then saves the transaction record in the DB.

    * **Failure:** If the payment fails, an error is returned, and the Controller triggers a "payment failed" state.

## 🛠️ Tech Stack
* **Language:** Java (JDK 17+)
* **UI Layouts:** XML (Android Layouts)
* **Architecture:** Following MVC/MVVM patterns
* **Modeling:** UML 2.0 (Stored in `/uml diagram`)

## 📂 Project Structure
* `/app/src/main/java`: Java source files for Activities, Fragments, and Logic.
* `/app/src/main/res/layout`: XML files defining the app's user interface.
* `/uml diagram`: Documentation of the system's design and architecture.

## 🚀 Roadmap
- [x] Finalize Use Case Diagram.
- [x] Complete Class Diagram (Attributes & Methods).
- [x] Finalize sequence Diagram.
- [x] Implement XML Layouts for Sign-Up/Log-In/Home screens.
- [ ] Develop Oracle/mySql integration for Authentication.

## ⚖️ License
This project is licensed under the Apache 2.0 License - see the [LICENSE](LICENSE) file for details.
