// src/components/Dashboard.jsx
import React, { useState, useEffect } from 'react';
import Header from './Header';
import HazardStatusCard from './HazardStatusCard';
import SentimentChart from './SentimentChart';
import PostFeed from './PostFeed';

const Dashboard = ({ onLogout }) => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  // Derived metrics
  const totalHazardPosts = data.filter(p => p.hazardLabel === 1).length;
  const totalSafePosts = data.filter(p => p.hazardLabel === 0).length;

  useEffect(() => {
    const fetchAnalytics = async () => {
      const token = localStorage.getItem('userToken');
      setLoading(true);
      setError(null);

      if (!token) {
        setError("User token not found. Please log in.");
        setLoading(false);
        return;
      }

      try {
        const response = await fetch('http://localhost:8080/api/hazard/analytics', {
          method: 'GET',
          headers: {
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json',
          },
        });

        if (response.ok) {
          const analyticsData = await response.json();

          const formattedData = analyticsData.map(post => ({
            ...post,
            hazardLabel: post.hazardLabel === '1' || post.hazardLabel === 1 ? 1 : 0,
            keywords: post.keywords ? post.keywords.split(',').map(k => k.trim()) : [],
          }));

          setData(formattedData);

        } else if (response.status === 401 || response.status === 403) {
          setError("Authentication expired or failed. Logging out...");
          onLogout();
        } else {
          setError(`Failed to fetch data: ${response.status}`);
        }

      } catch (err) {
        setError("Network error: Could not connect to Spring Boot API.");
        console.error("Fetch Error:", err);
      } finally {
        setLoading(false);
      }
    };

    fetchAnalytics();
  }, [onLogout]);

  // Loading screen
  if (loading) {
    return (
      <div style={styles.loadingContainer}>
        <h2 style={{ color: '#1a365d' }}>Loading Hazard Analytics...</h2>
      </div>
    );
  }

  // Error screen
  if (error) {
    return (
      <div style={styles.errorContainer}>
        <h2 style={{ color: '#e53e3e' }}>Error: {error}</h2>
        <button onClick={onLogout} style={styles.logoutButton}>Go to Login</button>
      </div>
    );
  }

  // Main dashboard
  return (
    <div className="dashboard-container" style={styles.dashboardContainer}>
      <Header onLogout={onLogout} />

      <div className="analytics-grid" style={styles.analyticsGrid}>
        
        <HazardStatusCard 
          title="Total Hazardous Reports"
          count={totalHazardPosts}
          color="#E53E3E"
          icon="🚨"
        />

        <HazardStatusCard 
          title="Total Safe Reports"
          count={totalSafePosts}
          color="#38A169"
          icon="✅"
        />

        <div style={{ background: 'transparent' }}></div>

        <div style={styles.postFeedArea}>
          <PostFeed data={data} />
        </div>

        <div style={styles.chartArea}>
          <h2>Sentiment Breakdown</h2>
          <SentimentChart data={data} />
        </div>
      </div>
    </div>
  );
};

const styles = {
  dashboardContainer: {
    padding: '0 50px',
    fontFamily: 'Arial, sans-serif',
    background: '#f7f9fc',
    minHeight: '100vh',
  },
  loadingContainer: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    minHeight: '100vh',
  },
  errorContainer: {
    display: 'flex',
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
    minHeight: '100vh',
  },
  analyticsGrid: {
    display: 'grid',
    gridTemplateColumns: 'repeat(3, 1fr)',
    gap: '25px',
    padding: '20px 0',
  },
  chartArea: {
    gridColumn: 'span 2',
    background: '#ffffff',
    padding: '20px',
    borderRadius: '8px',
    boxShadow: '0 2px 10px rgba(0,0,0,0.05)',
    minHeight: '350px',
  },
  postFeedArea: {
    gridColumn: 'span 1',
  },
  logoutButton: {
    marginTop: '20px',
    padding: '10px 20px',
    backgroundColor: '#3182ce',
    color: 'white',
    border: 'none',
    borderRadius: '6px',
    cursor: 'pointer',
  }
};

export default Dashboard;
