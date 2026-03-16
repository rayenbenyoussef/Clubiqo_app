# Clubiqo - Club/Organisation Management System 🚀📱

**Clubiqo** (formerly JCI Manager) is a comprehensive management solution designed to streamline club activities, member registrations, and administrative tasks [1].

### ⚠ Project Status: Final Beta Release (Frontend & Logic)
The mobile application has reached its **Final Beta** stage for UI/UX and core logic implementation [Source: Conversation].

**Important Technical Notes:**
*   **Android App Status:** The mobile interface is fully built in **Java/XML** but is currently **not connected to a live database** [Source: Conversation]. 
*   **Dummy Data:** All current features (registration, event browsing, dashboards) operate using **dummy data** to demonstrate the functional flow and system logic [Source: Conversation].
*   **Development Pivot:** Active development on the Android application is currently **paused**. The primary focus has shifted to completing the **PHP Web Manager** and backend infrastructure [Source: Conversation, 15].

---

### 🏗 System Architecture & Design
The project is built on a solid foundation of **UML 2.0 specifications**, ensuring a clean **MVC/MVVM** architecture [2].

#### 1. Logic Overview
*   **Identity Management:** Visitors can use the **Create Account** feature to become Members [3].
*   **Hierarchical Access:** Distinct roles for Members, Moderators, and Admins [3, 4].
*   **Security Layer:** Protected actions trigger the **LogIn** and **Authentication** modules [3].
*   **Feature Extensions:** Includes optional flows for **External Payment API** and **Attendance Confirmation** [3].

#### 2. Sequence Diagrams (Functional Blueprint)
The system logic is documented through detailed sequence diagrams in the `/uml diagram` folder, covering [5-10]:
*   **Account Creation & Recovery:** Handles email verification and password generation logic [5, 7].
*   **Authentication Flow:** Manages identity verification and access states [6].
*   **Event Management:** Implements **real-time capacity constraints** (verifying available spots) and participation tracking [8, 9].
*   **Payment System:** Logic for handling free vs. paid events and verifying external transactions [10].

---

### 📂 Project Structure
*   **`Clubiqo_android/`**: The mobile frontend source code (Java/XML) [11].
*   **`Clubiqo_web_manager/`**: **(Current Focus)** The PHP-based administrative backend [11].
*   **`uml diagram/`**: Documentation of the system's design and architecture [11].
*   **`screenshots/`**: Visual previews of the Final Beta UI [11].

---

### 🛠 Tech Stack
*   **Mobile:** Java (JDK 17+), XML Layouts [2, 12].
*   **Web/Backend:** PHP, CSS (Integration with MySQL/Oracle in progress) [12].
*   **Modeling:** UML 2.0 [2].

---

### 🚀 Roadmap
- [x] Finalize Use Case, Class, and Sequence Diagrams [2].
- [x] Implement XML Layouts for all core screens [2, 13].
- [x] **Final Beta Release:** Complete functional logic with dummy data [Source: Conversation].
- [ ] **In Progress:** Complete PHP Web Manager for centralized administration [Source: Conversation].
- [ ] Connect Android App to live Database (MySQL/Oracle).
- [ ] Final end-to-end integration testing.

---

### 📦 Downloads & Resources
*   **GitHub Repository:** [rayenbenyoussef/Clubiqo_app](https://github.com/rayenbenyoussef/Clubiqo_app)
*   **Final Beta APK:** [Insert Your Link Here]

---

### ⚖ License
This project is licensed under the **MIT License** [11, 12].
