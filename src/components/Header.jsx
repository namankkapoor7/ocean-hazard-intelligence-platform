// src/components/Header.jsx
import React from 'react';

const Header = ({ onLogout }) => {
    return (
        <header style={styles.header}>
            <h1 style={styles.title}>Ocean Hazard Monitoring Dashboard</h1>
            <button 
                onClick={onLogout} 
                style={styles.logoutButton}
            >
                Logout
            </button>
        </header>
    );
};

const styles = {
    header: {
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        padding: '20px 0',
        borderBottom: '1px solid #e2e8f0',
        marginBottom: '20px',
    },
    title: {
        fontSize: '28px',
        color: '#1a365d',
        margin: 0,
    },
    logoutButton: {
        padding: '10px 20px',
        backgroundColor: '#e53e3e',
        color: 'white',
        border: 'none',
        borderRadius: '6px',
        cursor: 'pointer',
        fontWeight: 'bold',
        transition: 'background-color 0.3s',
    }
};

export default Header;