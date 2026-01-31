// src/components/LoginPage.jsx
import React, { useState } from 'react';

const LoginPage = ({ onLogin }) => {
    // ✅ Updated default credentials for easier testing
    const [username, setUsername] = useState('testuser');
    const [password, setPassword] = useState('password123');
    
    const [error, setError] = useState('');
    const [loading, setLoading] = useState(false);

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');
        setLoading(true);

        // --- CONNECTION POINT: Call Spring Boot AuthController ---
        try {
            const response = await fetch('http://localhost:8080/api/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ username, password }),
            });

            setLoading(false);

            if (response.ok) {
                // Assume Spring returns { token: "..." } on success
                const data = await response.json(); 
                
                // Pass the token back to App.js to set state and store in localStorage
                // NOTE: App.js expects only the token, as per the previous App.js code.
                onLogin(data.token); 
            } else {
                // Handle 401 Unauthorized or other errors
                setError('Login failed. Check username and password.');
                console.error("Login failed:", response.status);
            }
        } catch (err) {
            setLoading(false);
            setError('Cannot connect to the backend server. Check CORS settings or if Spring Boot is running.');
            console.error("Network Error:", err);
        }
    };

    return (
        <div style={styles.loginContainer}>
            <div style={styles.card}>
                <h1 style={styles.header}>🌊 Ocean Hazard Dashboard</h1>
                <h2 style={styles.subheader}>Authority Login</h2>
                
                <form onSubmit={handleSubmit}>
                    <input
                        type="text"
                        placeholder="Username (e.g., testuser)"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        style={styles.input}
                        required
                    />
                    <input
                        type="password"
                        placeholder="Password (e.g., password123)"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        style={styles.input}
                        required
                    />

                    {error && <p style={styles.error}>{error}</p>}

                    <button type="submit" style={styles.button} disabled={loading}>
                        {loading ? 'Logging in...' : 'Login'}
                    </button>
                </form>
            </div>
        </div>
    );
};

const styles = {
    loginContainer: {
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        minHeight: '100vh',
        background: '#0e1e3b', // Deep ocean blue background
        fontFamily: 'Arial, sans-serif',
    },
    card: {
        background: '#ffffff',
        padding: '40px',
        borderRadius: '12px',
        boxShadow: '0 8px 30px rgba(0, 0, 0, 0.4)',
        textAlign: 'center',
        width: '350px',
    },
    header: {
        color: '#1a365d',
        fontSize: '28px',
        marginBottom: '5px',
    },
    subheader: {
        color: '#4a5568',
        fontSize: '16px',
        fontWeight: 'normal',
        marginBottom: '30px',
    },
    input: {
        width: '100%',
        padding: '12px',
        margin: '10px 0',
        borderRadius: '6px',
        border: '1px solid #e2e8f0',
        boxSizing: 'border-box',
        fontSize: '16px',
    },
    error: {
        color: '#e53e3e',
        fontSize: '14px',
        marginTop: '10px',
    },
    button: {
        width: '100%',
        padding: '12px',
        marginTop: '20px',
        borderRadius: '6px',
        border: 'none',
        background: '#3182ce', // Primary blue button
        color: 'white',
        fontSize: '18px',
        fontWeight: 'bold',
        cursor: 'pointer',
        transition: 'background-color 0.3s',
    }
};

export default LoginPage;