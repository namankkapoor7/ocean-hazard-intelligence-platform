import joblib
from preprocess import preprocess_text
from sentiment import get_sentiment
from keywords import extract_keywords
from keybert import KeyBERT


# Load model + vectorizer (These are loaded only once on API startup)
print("Loading model + vectorizer...")
try:
    model = joblib.load("models/hazard_classifier.pkl")
    vectorizer = joblib.load("models/tfidf_vectorizer.pkl")
except FileNotFoundError as e:
    raise FileNotFoundError(f"Model file not found. Have you run train_classifier.py? Error: {e}")

# Load KeyBERT once
print("Loading KeyBERT model...")
kw_model = KeyBERT()


def predict_comment(text):
    """Process a single comment and return ML results"""

    # 1. Cleaning
    cleaned = preprocess_text(text)

    # 2. Classification
    vec = vectorizer.transform([cleaned])
    hazard_pred = int(model.predict(vec)[0])

    # 3. Sentiment Analysis
    sentiment = get_sentiment(cleaned)

    # 4. Keyword Extraction
    keywords = extract_keywords(cleaned, kw_model)
    # Convert comma-separated string back to a list
    if keywords:
        keywords = [k.strip() for k in keywords.split(",")]
    else:
        keywords = []

    # FINAL API-READY FORMAT
    return {
        "text": text,
        "hazard_label": hazard_pred,
        "sentiment": sentiment,
        "keywords": keywords
    }


def predict_batch(text_list):
    """Process a list of comments and return results"""
    return [predict_comment(text) for text in text_list]


# Local Testing (Optional)
if __name__ == "__main__":
    # Ensure you have run all training steps before running this
    sample_input = [
        "Sea water entering the road here",
        "Huge waves rising suddenly!",
    ]

    output = predict_batch(sample_input)
    for o in output:
        print(o)