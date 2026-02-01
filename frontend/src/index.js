// src/index.js
import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';

// NOTE: You can optionally add a global CSS file here if you create one (e.g., './index.css')

// Use createRoot() for React 18+ to render the application
const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);