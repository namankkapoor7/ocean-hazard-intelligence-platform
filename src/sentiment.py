from transformers import AutoTokenizer, AutoModelForSequenceClassification
import torch


# Load model & tokenizer
MODEL_NAME = "nlptown/bert-base-multilingual-uncased-sentiment"

tokenizer = AutoTokenizer.from_pretrained(MODEL_NAME)
model = AutoModelForSequenceClassification.from_pretrained(MODEL_NAME)


# Function to get sentiment label
def get_sentiment(text):
    inputs = tokenizer(text, return_tensors="pt", truncation=True, padding=True)

    with torch.no_grad():
        outputs = model(**inputs)

    scores = outputs.logits.softmax(dim=1)[0]
    label_id = torch.argmax(scores).item()

    # Model labels: 1-star = very negative → 5-star = very positive
    if label_id in [0, 1]:
        return "fear"      # negative or very negative
    elif label_id == 2:
        return "neutral"
    else:
        return "positive"


# Test 
if __name__ == "__main__":
    samples = [
        "The waves are getting too high here, very scary!",
        "Everything is normal at the beach today.",
        "What a beautiful day by the sea!"
    ]

    for s in samples:
        print(s, "→", get_sentiment(s))
