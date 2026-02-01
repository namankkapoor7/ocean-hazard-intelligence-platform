import pandas as pd
import re
import emoji
import nltk
from nltk.corpus import stopwords
from nltk.stem import WordNetLemmatizer

# --- Ensure NLTK resources are available ---
try:
    nltk.data.find('corpora/wordnet')
    nltk.data.find('corpora/stopwords')
except LookupError:
    print("Downloading NLTK resources (wordnet, stopwords)...")
    nltk.download('wordnet')
    nltk.download('stopwords')
# --- END FIX ---

# Initialize tools
stop_words = set(stopwords.words("english"))
lemmatizer = WordNetLemmatizer()


def remove_urls(text):
    return re.sub(r"http\S+|www\S+|https\S+", "", text)


def remove_emojis(text):
    return emoji.replace_emoji(text, replace='')


def remove_special_chars(text):
    return re.sub(r"[^a-zA-Z\s]", " ", text)


def clean_whitespace(text):
    return re.sub(r"\s+", " ", text).strip()


def preprocess_text(text):
    if pd.isnull(text):
        return ""

    text = text.lower()
    text = remove_urls(text)
    text = remove_emojis(text)
    text = remove_special_chars(text)
    text = clean_whitespace(text)

    # Tokenize & remove stopwords
    tokens = [word for word in text.split() if word not in stop_words]

    # Lemmatize
    tokens = [lemmatizer.lemmatize(word) for word in tokens]

    # Remove very short words
    tokens = [word for word in tokens if len(word) > 2]

    return " ".join(tokens)


def preprocess_csv(input_path, output_path):
    print("Loading CSV...")
    df = pd.read_csv(input_path)

    print("Cleaning text...")
    df["clean_text"] = df["text"].astype(str).apply(preprocess_text)

    df = df[df["clean_text"].str.strip() != ""]

    df.to_csv(output_path, index=False)
    print("Saved cleaned CSV to:", output_path)


def clean_text(text):
    return preprocess_text(text)


if __name__ == "__main__":
    preprocess_csv("data/youtube_comments.csv", "data/cleaned_comments.csv")
