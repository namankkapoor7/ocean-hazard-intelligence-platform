// src/components/PostFeed.jsx
import React from 'react';

const PostFeed = ({ data }) => {

    const getColor = (label) => {
        return label === 1 ? '#e53e3e' : '#38a169'; // Red for Hazard (1), Green for Safe (0)
    };

    return (
        <div style={styles.feedContainer}>
            <h2 style={styles.feedHeader}>Recent Analysis Feed ({data.length} Total)</h2>
            <div style={styles.postList}>
                {data.map((post) => (
                    <div key={post.id} style={styles.postCard}>
                        <div style={styles.headerRow}>
                            <span style={{ 
                                ...styles.labelTag, 
                                backgroundColor: getColor(post.hazardLabel) 
                            }}>
                                {post.hazardLabel === 1 ? '🚨 HAZARD' : '✅ SAFE'}
                            </span>
                            <span style={styles.date}>{new Date(post.createdAt).toLocaleString()}</span>
                        </div>
                        
                        <p style={styles.text}>{post.originalText}</p>
                        
                        <div style={styles.keywordContainer}>
                            <strong>Keywords:</strong> 
                            {post.keywords && post.keywords.map((kw, index) => (
                                <span key={index} style={styles.keywordTag}>{kw}</span>
                            ))}
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
};

const styles = {
    feedContainer: {
        padding: '10px',
        background: '#ffffff',
        borderRadius: '8px',
        boxShadow: '0 2px 10px rgba(0,0,0,0.05)',
        height: '480px', // Fixed height for scrollability
        overflowY: 'auto',
    },
    feedHeader: {
        fontSize: '20px',
        marginBottom: '15px',
        color: '#1a365d',
    },
    postList: {
        display: 'flex',
        flexDirection: 'column',
        gap: '15px',
    },
    postCard: {
        border: '1px solid #e2e8f0',
        padding: '15px',
        borderRadius: '6px',
        background: '#f7f9fc',
    },
    headerRow: {
        display: 'flex',
        justifyContent: 'space-between',
        marginBottom: '10px',
        alignItems: 'center',
    },
    labelTag: {
        color: 'white',
        padding: '4px 8px',
        borderRadius: '4px',
        fontSize: '12px',
        fontWeight: 'bold',
    },
    date: {
        fontSize: '12px',
        color: '#718096',
    },
    text: {
        margin: '0 0 10px 0',
        fontSize: '14px',
        lineHeight: '1.4',
        color: '#2d3748',
    },
    keywordContainer: {
        fontSize: '12px',
        color: '#4a5568',
        display: 'flex',
        flexWrap: 'wrap',
        alignItems: 'center',
    },
    keywordTag: {
        backgroundColor: '#e9ebee',
        color: '#4c4f52',
        padding: '3px 8px',
        borderRadius: '12px',
        margin: '0 5px',
        fontWeight: 'normal',
    }
};

export default PostFeed;