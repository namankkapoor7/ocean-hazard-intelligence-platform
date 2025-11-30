import pandas as pd
import re
import emoji
import nltk
from nltk.corpus import stopwords
from nltk.stem import WordNetLemmatizer

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

    text = text.lower()                      # lowercase
    text = remove_urls(text)                 # remove URLs
    text = remove_emojis(text)               # remove emojis
    text = remove_special_chars(text)        # remove special chars
    text = clean_whitespace(text)            # remove extra spaces

    # Tokenize
    tokens = text.split()

    # Remove stopwords
    tokens = [word for word in tokens if word not in stop_words]

    # Lemmatize
    tokens = [lemmatizer.lemmatize(word) for word in tokens]

    # Remove very short words (noise)
    tokens = [word for word in tokens if len(word) > 2]

    return " ".join(tokens)


def preprocess_csv(input_path, output_path):
    print("Loading CSV...")
    df = pd.read_csv(input_path)

    print("Cleaning text...")
    df["clean_text"] = df["text"].astype(str).apply(preprocess_text)

    # Remove empty rows
    df = df[df["clean_text"].str.strip() != ""]

    df.to_csv(output_path, index=False)
    print("Saved cleaned CSV to:", output_path)
    print(df.head())

def clean_text(text):
    return preprocess_text(text)


if __name__ == "__main__":
    preprocess_csv("data/youtube_comments.csv", "data/cleaned_comments.csv")
