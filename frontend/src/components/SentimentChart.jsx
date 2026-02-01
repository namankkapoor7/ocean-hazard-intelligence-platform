// src/components/SentimentChart.jsx
import React from 'react';
import { PieChart, Pie, Tooltip, Cell, ResponsiveContainer } from 'recharts';

const COLORS = {
    fear: '#E53E3E',     // Red
    neutral: '#4299E1',  // Blue
    positive: '#38A169', // Green
};

const SentimentChart = ({ data }) => {

    // 1. Count sentiments
    const sentimentCounts = data.reduce((acc, post) => {
        const sentiment = post.sentiment.toLowerCase();
        acc[sentiment] = (acc[sentiment] || 0) + 1;
        return acc;
    }, {});

    // 2. Convert into chart format
    const chartData = Object.keys(sentimentCounts).map(key => ({
        name: key.charAt(0).toUpperCase() + key.slice(1),
        value: sentimentCounts[key],
    }));

    if (chartData.length === 0) {
        return (
            <p style={{ textAlign: 'center', padding: '50px', color: '#6b7280' }}>
                No sentiment data available for visualization.
            </p>
        );
    }

    return (
        <div style={{ height: '300px', width: '100%' }}>
            <ResponsiveContainer width="100%" height="100%">
                <PieChart>
                    <Pie
                        data={chartData}
                        dataKey="value"
                        nameKey="name"
                        cx="50%"
                        cy="50%"
                        outerRadius={100}
                        fill="#8884d8"
                        labelLine={false}
                        label={({ name, percent }) => `${name}: ${(percent * 100).toFixed(0)}%`}
                    >
                        {chartData.map((entry, index) => (
                            <Cell 
                                key={`cell-${index}`} 
                                fill={COLORS[entry.name.toLowerCase()] || '#ccc'} 
                            />
                        ))}
                    </Pie>
                    <Tooltip />
                </PieChart>
            </ResponsiveContainer>
        </div>
    );
};

export default SentimentChart;
