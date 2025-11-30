import joblib
from preprocess import preprocess_text
from sentiment import get_sentiment
from keywords import extract_keywords
from keybert import KeyBERT


# Load model + vectorizer

print("Loading model + vectorizer...")
model = joblib.load("models/hazard_classifier.pkl")
vectorizer = joblib.load("models/tfidf_vectorizer.pkl")

# Load KeyBERT once
print("Loading KeyBERT model...")
kw_model = KeyBERT()


# Predict for a single comment

def predict_comment(text):
    """Process a single comment and return ML results"""

    # Clean the text
    cleaned = preprocess_text(text)

    # Classification
    vec = vectorizer.transform([cleaned])
    hazard_pred = int(model.predict(vec)[0])

    # Sentiment Analysis
    sentiment = get_sentiment(cleaned)

    # Keyword Extraction
    keywords = extract_keywords(cleaned, kw_model)
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


# Predict for a list of comments

def predict_batch(text_list):
    """Process a list of comments and return results"""
    return [predict_comment(text) for text in text_list]


# Local Testing (Optional)

if __name__ == "__main__":
    sample_input = [
        "Sea water entering the road here",
        "Beautiful calm day at the beach",
        "Huge waves rising suddenly!",
        "Nothing unusual happening",
        "Bahut tez hawa chal rahi hai yaha",
        "Paani sadak tak aa gaya!"
    ]

    output = predict_batch(sample_input)
    for o in output:
        print(o)
