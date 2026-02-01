// src/components/HazardStatusCard.jsx
import React from 'react';

const HazardStatusCard = ({ title, count, color, icon }) => {
  return (
    <div 
      className="status-card"
      style={{ 
        ...styles.card,
        borderLeft: `5px solid ${color}` 
      }}
    >
      <div style={styles.content}>
        <p style={styles.title}>{title}</p>
        <h1 style={{ ...styles.count, color: color }}>{count}</h1>
      </div>
      <div style={styles.iconContainer}>
        <span style={styles.icon}>{icon}</span>
      </div>
    </div>
  );
};

const styles = {
  card: {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    background: '#ffffff',
    padding: '20px',
    borderRadius: '8px',
    boxShadow: '0 4px 12px rgba(0,0,0,0.1)',
    transition: 'transform 0.3s',
  },
  content: {
    display: 'flex',
    flexDirection: 'column',
  },
  title: {
    margin: 0,
    color: '#6b7280',
    fontSize: '14px',
    fontWeight: 'bold',
    textTransform: 'uppercase',
  },
  count: {
    margin: '5px 0 0',
    fontSize: '48px',
    fontWeight: 800,
  },
  iconContainer: {
    fontSize: '40px',
    opacity: 0.6,
  },
  icon: {
    transform: 'scale(1.2)',
  }
};

export default HazardStatusCard;
