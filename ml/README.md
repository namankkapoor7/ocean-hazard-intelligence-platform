# ML Module for Ocean Hazard Social Media Analysis

This repository contains the Machine Learning module for the Ocean Hazard Social Media Analytics project.
The ML module is responsible for:

    🔹Classifying hazard-related comments
    🔹Performing sentiment analysis
    🔹Extracting important keywords
    🔹Returning structured JSON output
    🔹Integrating with backend APIs
    🔹Backend developers must use the provided Python scripts/models to run ML inference and store results into MySQL for the dashboard.

---    

## 📁 Project Structure

```
ML/
│
├── src/
│   ├── pipeline.py
│   ├── preprocess.py
│   ├── sentiment.py
│   ├── keywords.py
│   ├── scraper_youtube.py     (optional: for live scraping)
│   └── extract_labeled.py     (optional: used only during training)
│
├── models/
│   ├── hazard_classifier.pkl
│   └── tfidf_vectorizer.pkl
│
├── data/
│   ├── youtube_comments      
│   ├── cleaned_comments    
│   ├── labeled_dataset      
|   ├── training_metrics      
|   ├── keywords_output      
|   ├── new_comments.csv      (example input file)
|   └── final_output.csv      (example output)
|
├── requirements.txt
|
└── README.md
```

---
