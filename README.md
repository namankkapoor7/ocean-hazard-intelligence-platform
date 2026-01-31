# ocean-hazard-intelligence-platform
This React frontend code serves as the core entry point for an application focused on data visualization and secure user access. It manages the fundamental user journey—moving from an authentication screen to a functional dashboard.

🛠️ Technology Stack & Languages
The project is built using a modern JavaScript ecosystem:

JavaScript (ES6+): The primary programming language used for logic, state management, and handling browser storage.

React.js (v18.2.0): The UI library used to build the component-based architecture.

JSX: A syntax extension for JavaScript used to describe what the UI should look like.

CSS: Used for styling the application layout (referenced via app-container).

JSON: Used for configuration and dependency management (via package.json).

📦 Key Libraries & Dependencies
Based on the project configuration, the frontend utilizes:

Recharts: A composable charting library used for rendering data visualizations on the Dashboard.

LocalStorage API: A web storage API used to persist the userToken so users stay logged in after a page refresh.

⚙️ Component Logic: App.js
The App.js file acts as the Root Controller and Authentication Guard. It implements a conditional rendering pattern to manage user sessions.

1. Session Persistence
The app initializes its state by checking the browser's localStorage. If a userToken is present, it automatically authenticates the user, providing a seamless "remember me" experience.

2. Authentication Handlers
handleLogin: Triggered upon successful credentials entry. It saves the unique security token to the browser and updates the UI state to grant access.

handleLogout: Safely clears the security token from the browser and immediately redirects the user back to the login screen.

3. Dynamic Rendering
The component uses a "Gatekeeper" logic to determine which view the user sees:

Dashboard View: Displayed only when isAuthenticated is true. It receives the logout functionality as a prop.

LoginPage View: The default view for unauthenticated users, which receives the login functionality as a prop.

🚀 Summary
This frontend is a React-based implementation for an Integrated Platform for Crowdsourced Ocean Hazard Reporting and Social Media Analytics. It leverages functional components and hooks to create a secure, state-driven user interface that integrates complex data visualizations through Recharts.
