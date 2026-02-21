# 🧠 Machine Learning Module  
**Ocean Hazard Detection using Social Media Analytics**

This module is responsible for **collecting, processing, and analyzing social media text data** to detect early indicators of ocean-related hazards. It uses **Natural Language Processing (NLP)** and **Machine Learning (ML)** techniques to classify social media posts, analyze public sentiment, and extract trending keywords.

---

## 📌 Module Overview

The ML module acts as the **intelligence layer** of the system. It processes raw YouTube comments related to ocean conditions and transforms them into structured insights that can be consumed by the backend and visualized on the frontend dashboard.

### Key Responsibilities
- Scrape social media comments (YouTube)
- Clean and preprocess text data
- Classify posts as **Hazard / Non-Hazard**
- Perform **sentiment analysis**
- Extract **trending keywords**
- Expose an API endpoint for backend integration

---

## 🧩 Folder Structure

```text
ml/
│
├── data/                     # Raw and processed datasets
│   ├── youtube_comments.csv
│   ├── cleaned_comments.csv
│   ├── labeled_dataset.csv
│   ├── final_output.csv
│   └── training_metrics.csv
│
├── models/                   # Trained ML models
│   ├── hazard_classifier.pkl
│   └── tfidf_vectorizer.pkl
│
├── src/                      # Source code
│   ├── api.py                # Flask API for predictions
│   ├── scraper_youtube.py    # YouTube comment scraper
│   ├── preprocess.py         # Text cleaning & preprocessing
│   ├── train_classifier.py   # Model training script
│   ├── pipeline.py           # End-to-end ML pipeline
│   ├── sentiment.py          # Sentiment analysis logic
│   ├── keywords.py           # Keyword extraction
│   └── extract_labeled.py    # Dataset labeling utility
│
├── requirements.txt          # Python dependencies
└── README.md                 # ML module documentation
```

---

## 🧠 Machine Learning Pipeline

### 1️⃣ Data Collection
- Scrapes YouTube comments related to ocean conditions  
- Uses `yt-dlp` to extract:
  - Comment text  
  - Author  
  - Timestamp  
- Removes duplicate and noisy entries  

---

### 2️⃣ Text Preprocessing
- Lowercasing text  
- Removing punctuation and special characters  
- Tokenization  
- Stopword removal  
- Text normalization  

---

### 3️⃣ Feature Extraction
- Converts text into numerical features using **TF-IDF Vectorization**

---

### 4️⃣ Classification
- Uses **Logistic Regression**
- Classifies comments into:
  - **Hazard**
  - **Non-Hazard**

---

### 5️⃣ Sentiment Analysis
- Determines emotional tone of comments:
  - Positive  
  - Neutral  
  - Negative  
- Helps assess public panic or alertness  

---

### 6️⃣ Keyword Extraction
- Identifies trending hazard-related terms  
- Useful for early signal detection  

---

## 🔌 ML API (Integration Layer)

The ML module exposes a **REST API** that allows the backend to send batches of comments and receive predictions.

### API Endpoint
```http
POST /analyze
```
### Input (JSON)
```json
{
  "comments": [
    "High waves near the coast today",
    "Everything looks normal at the beach"
  ]
}
```
### Output (JSON)
```json
{
  "results": [
    {
      "comment": "High waves near the coast today",
      "label": "Hazard",
      "sentiment": "Negative",
      "keywords": ["high waves", "coast"]
    }
  ]
}
```

---

## 🛠️ Tech Stack

### Programming Language
- Python 3.9+

### Libraries & Frameworks
- scikit-learn  
- pandas  
- numpy  
- joblib  
- KeyBERT  
- yt-dlp  
- Flask / FastAPI  

### ML Techniques
- TF-IDF Vectorization  
- Logistic Regression  
- NLP-based sentiment analysis  

---

## 🚀 How to Run the ML Module

### 1️⃣ Create Virtual Environment (Recommended)
```bash
python -m venv venv
source venv/bin/activate      # Linux / Mac
venv\Scripts\activate         # Windows
```
### 2️⃣ Install Dependencies
```bash
pip install -r requirements.txt
```
### 3️⃣ Run the ML API
```bash
python src/api.py
```

The API will start locally and wait for backend requests.

---

## 📊 Output Generated
- Classified comments (**Hazard / Non-Hazard**)  
- Sentiment labels  
- Extracted keywords  
- Structured datasets ready for database storage  

---

## 🔮 Future Enhancements
- Replace Logistic Regression with deep learning models (BERT, LSTM)  
- Multilingual text support  
- Image and video content analysis  
- Geo-location based hazard tagging  
- Real-time streaming analysis  

---

## 📜 Notes
- Trained models are stored in `/models`  
- Datasets are versioned inside `/data`  
- This module is **decoupled** and can be scaled independently  

---

## 👤 Maintainer
**Naman Kapoor**  
Machine Learning & System Integration  

---

This ML module serves as the **core intelligence engine** of the Ocean Hazard Intelligence Platform.
